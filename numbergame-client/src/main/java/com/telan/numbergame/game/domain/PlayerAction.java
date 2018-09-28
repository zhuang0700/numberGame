package com.telan.numbergame.game.domain;

import com.telan.numbergame.domain.UserDO;
import com.telan.numbergame.param.GameBaseRequest;

import java.util.Date;
import java.util.List;

/**
 * Created by weiwenliang on 17/5/15.
 */
public class PlayerAction extends GameBaseRequest {
    private UserDO userDO;

    public long fromPlayerId;

    public long toPlayerId;

    public List<Long> extraPlayerList;

    public Date actionTime;

    public int actionType;

    public String msg = "YES";

    public UserDO getUserDO() {
        return userDO;
    }

    public void setUserDO(UserDO userDO) {
        this.userDO = userDO;
    }
}
