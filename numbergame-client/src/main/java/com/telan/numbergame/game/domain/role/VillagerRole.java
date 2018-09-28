package com.telan.numbergame.game.domain.role;

import com.telan.numbergame.game.enums.RoleType;

/**
 * Created by weiwenliang on 17/5/15.
 */
public class VillagerRole extends BaseRole {

    public VillagerRole(){
        this.setRole(RoleType.VILLAGER.getType());
    }
}
