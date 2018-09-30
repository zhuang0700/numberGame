package com.telan.numbergame.utils.conventor;

import com.telan.numbergame.domain.GameDO;
import com.telan.numbergame.domain.UserDO;
import com.telan.numbergame.game.enums.GameStatus;
import com.telan.numbergame.game.param.CreateGameParam;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by weiwenliang on 17/5/31.
 */
public class GameConvertor{


    public static GameDO convertGameDOForCreate(CreateGameParam param) {
        GameDO gameDO = new GameDO();
        UserDO userDO = param.getCreator();
        gameDO.setGameId(userDO.getId());
        gameDO.setGmtCreated(new Date());
        gameDO.setGmtModified(new Date());
        gameDO.setType(1);
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
