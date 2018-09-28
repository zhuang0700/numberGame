package com.telan.numbergame.game.domain.role;

import com.telan.numbergame.game.enums.RoleType;

/**
 * Created by weiwenliang on 17/5/15.
 */
public class SeerRole extends BaseRole {

    public SeerRole(){
        this.setRole(RoleType.SEER.getType());
        this.setName(RoleType.SEER.getName());
        this.setDesc(RoleType.SEER.getDescription());
    }
}
