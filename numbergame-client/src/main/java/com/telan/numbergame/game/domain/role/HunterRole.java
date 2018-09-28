package com.telan.numbergame.game.domain.role;

import com.telan.numbergame.game.enums.RoleType;

/**
 * Created by weiwenliang on 17/5/15.
 */
public class HunterRole extends BaseRole {

    public HunterRole(){
        this.setRole(RoleType.HUNTER.getType());
    }
}
