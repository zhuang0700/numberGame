package com.telan.numbergame.utils.conventor;

import com.telan.numbergame.domain.GameDO;
import com.telan.numbergame.domain.UserDO;
import com.telan.numbergame.game.enums.GameStatus;
import com.telan.numbergame.game.param.CreateGameParam;
import com.telan.numbergame.game.param.OperateGameParam;
import org.springframework.core.convert.converter.Converter;

import java.util.*;

/**
 * Created by weiwenliang on 17/5/31.
 */
public class GameConvertor{


    public static GameDO convertGameDOForCreate(CreateGameParam param) {
        GameDO gameDO = new GameDO();
        UserDO userDO = param.getCreator();
        gameDO.setGameTypeId(userDO.getId());
        gameDO.setGmtCreated(new Date());
        gameDO.setGmtModified(new Date());
        gameDO.setType(1);
        return gameDO;
    }

    public static GameDO convertGameDOForOperator(OperateGameParam param) {
        GameDO gameDO = new GameDO();
        gameDO.setGameTypeId(param.getGameType());
        gameDO.setType(param.getGameType());
        gameDO.setUserId(param.getUser().getId());
        gameDO.setGmtCreated(new Date());
        gameDO.setGmtModified(new Date());
        gameDO.setStatus(GameStatus.PROCESS.getType());
        gameDO.setProgress(param.getProgress());
        gameDO.setScore(param.getScore());
        return gameDO;
    }

    public static Long convertGameDO(GameDO gameDO) {
        return gameDO.getId();
    }

    public static DefaultConvertor defaultConvertor;

    public static DefaultConvertor getDefaultConvertor() {
        if(defaultConvertor == null) {
            defaultConvertor = new DefaultConvertor();
        }
        return defaultConvertor;
    }

    public static class DefaultConvertor implements Converter<GameDO, Long> {
        @Override
        public Long convert(GameDO gameDO) {
            return convertGameDO(gameDO);
        }
    }
}
