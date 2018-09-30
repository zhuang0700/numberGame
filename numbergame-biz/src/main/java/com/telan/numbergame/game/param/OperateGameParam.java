package com.telan.numbergame.game.param;

import com.telan.numbergame.domain.UserDO;
import com.telan.numbergame.param.GameBaseRequest;

/**
 * Created by weiwenliang on 17/5/29.
 */
public class OperateGameParam extends GameBaseRequest{
    private UserDO user;

    private Integer status;

    private Long progress;

    private Long score;

    public UserDO getUser() {
        return user;
    }

    public void setUser(UserDO user) {
        this.user = user;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getProgress() {
        return progress;
    }

    public void setProgress(Long progress) {
        this.progress = progress;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}
