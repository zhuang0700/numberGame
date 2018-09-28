package com.telan.numbergame.game.param;

import com.telan.numbergame.domain.UserDO;

/**
 * Created by weiwenliang on 17/5/29.
 */
public class CreateGameParam {
    private UserDO creator;
    private int playerNum;

    public UserDO getCreator() {
        return creator;
    }

    public void setCreator(UserDO creator) {
        this.creator = creator;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }
}
