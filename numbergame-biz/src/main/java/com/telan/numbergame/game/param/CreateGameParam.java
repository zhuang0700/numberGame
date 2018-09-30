package com.telan.numbergame.game.param;

import com.telan.numbergame.domain.UserDO;

/**
 * Created by weiwenliang on 17/5/29.
 */
public class CreateGameParam {
    private UserDO creator;
    private long gameId;

    public UserDO getCreator() {
        return creator;
    }

    public void setCreator(UserDO creator) {
        this.creator = creator;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }
}
