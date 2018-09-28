package com.telan.numbergame.game.manager;

import com.telan.numbergame.game.domain.GameConfig;
import com.telan.numbergame.game.vo.UserGameConfig;

/**
 * Created by weiwenliang on 17/6/6.
 */
public class ConfigEngine {
    public static GameConfig convertGameConfig(GameConfig oldConfig, UserGameConfig userGameConfig) {
        oldConfig.setVictoryRule(userGameConfig.getVictoryRule());
        oldConfig.setRoleNum(userGameConfig.getRoleNum());
        oldConfig.setCustomRoleList(userGameConfig.isCustomRoleList());
        return oldConfig;
    }
}
