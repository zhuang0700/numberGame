package com.telan.numbergame.factory;

import com.telan.numbergame.game.domain.GameMsg;
import com.telan.numbergame.game.domain.Visibility;
import com.telan.numbergame.game.enums.GameMsgSubType;

import java.util.Date;
import java.util.List;

/**
 * Created by weiwenliang on 17/5/31.
 */
public class GameMsgFactory {
    public static GameMsg createGameMsg(GameMsgSubType gameMsgSubType, Visibility visibility, Object[] objects) {
        GameMsg gameMsg = new GameMsg();
        gameMsg.setSubType(gameMsgSubType.getSubType());
        gameMsg.setType(gameMsgSubType.getType());
        gameMsg.setActionTime(new Date());
        gameMsg.setVisibility(visibility);
        gameMsg.setObjects(objects);
        return gameMsg;
    }
}
