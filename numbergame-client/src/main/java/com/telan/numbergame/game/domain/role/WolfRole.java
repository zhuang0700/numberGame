package com.telan.numbergame.game.domain.role;

import com.telan.numbergame.game.domain.role.BaseRole;
import com.telan.numbergame.game.enums.RoleType;

/**
 * Created by weiwenliang on 17/5/15.
 */
public class WolfRole extends BaseRole {

    public WolfRole(){
        this.setRole(RoleType.WOLF.getType());
    }
}
