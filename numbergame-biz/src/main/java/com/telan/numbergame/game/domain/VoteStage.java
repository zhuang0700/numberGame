package com.telan.numbergame.game.domain;

import com.telan.numbergame.enums.WeErrorCode;
import com.telan.numbergame.factory.GameMsgFactory;
import com.telan.numbergame.game.domain.record.BaseRecord;
import com.telan.numbergame.game.domain.role.BaseRole;
import com.telan.numbergame.game.enums.*;
import com.telan.numbergame.game.manager.GameEngine;
import com.telan.numbergame.game.manager.PlayerEngine;
import com.telan.numbergame.game.manager.RecordEngine;
import com.telan.numbergame.manager.MemGameManager;
import com.telan.numbergame.result.WeBaseResult;
import com.telan.numbergame.result.WeResultSupport;
import com.telan.numbergame.utils.ActionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by weiwenliang on 17/5/15.
 */
public class VoteStage extends Stage {

    private int repeatNum = 1;

    public VoteStage(){
        super();
        this.stageType = StageType.VOTE;
    }

    @Override
    public void roleStart() {
        GameMsg msg = GameMsgFactory.createGameMsg(GameMsgSubType.STAGE_START, Visibility.ALL, new Object[]{stageType.getDesc()});
        RecordEngine.sendNormalMsg(gameInfo, msg);
        waitingAction();
    }

    @Override
    public void roleWaitingAction() {
        return;
    }

    @Override
    public void roleAnalyse() {
        List<Player> voters = PlayerEngine.getPlayersByRoleAndStatus(gameInfo, PlayerStatus.LIVE.getType(), -1);
        if(CollectionUtils.isEmpty(voters)) {
            finish();
            return;
        }
        if(actionList.size() == voters.size()) {
            finish();
            return;
        }
    }

    private void reVote() {
        this.repeatNum++;
        this.start();
    }

    @Override
    public void roleFinish() {
        RecordEngine.sendVoteActionMsg(gameInfo, actionList);
        List<Long> maxVoteIds = ActionUtil.findMaxVote(voteMap);
        if(!CollectionUtils.isEmpty(maxVoteIds) && maxVoteIds.size() > 1 && repeatNum < getGameConfig().getMaxEqualVoteBeforeNight()) {
            RecordEngine.sendVoteResultMsg(gameInfo, GameMsgSubType.VOTE_RESULT.getSubType(), maxVoteIds, true);
            reVote();
        } else {
            RecordEngine.sendVoteResultMsg(gameInfo, GameMsgSubType.VOTE_RESULT.getSubType(), maxVoteIds, false);
            if(!CollectionUtils.isEmpty(maxVoteIds) && maxVoteIds.size() == 1) {
                Map<Long, Integer> deathInfo = new HashMap<>();
                deathInfo.put(maxVoteIds.get(0), DeadReason.VOTE.getType());
                if(!PlayerEngine.setPlayerDead(gameInfo, deathInfo, this)) {
                    //stop
                }
            }
            GameEngine.tryEndGame(gameInfo);
        }
    }

    @Override
    public WeBaseResult<ActionResult> roleUserAction(Player player, PlayerAction action){
        WeBaseResult<ActionResult> resultSupport = new WeBaseResult<ActionResult>();
        if(action.actionType == ActionType.VOTE.getType()) {
            if(ActionUtil.findActionByFromId(actionList, action.fromPlayerId) != null) {
                resultSupport.setErrorCode(WeErrorCode.DUPLICATE_ACTION);
                return resultSupport;
            }
            Player toPlayer = getPlayerMap().get(action.toPlayerId);
            if(toPlayer == null || toPlayer.getStatus() != PlayerStatus.LIVE.getType()) {
                resultSupport.setErrorCode(WeErrorCode.WRONG_ACTION_TARGET);
                return resultSupport;
            }
            actionList.add(action);
            if(voteMap.get(action.toPlayerId) == null) {
                List<PlayerAction> actions = new ArrayList<>();
                actions.add(action);
                voteMap.put(action.toPlayerId, actions);
            } else{
                voteMap.get(action.toPlayerId).add(action);
            }
            analyse();
        } else {
            resultSupport.setErrorCode(WeErrorCode.UNSUPPORT_ACTION);
        }
        return resultSupport;
    }
}
