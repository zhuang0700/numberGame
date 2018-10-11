package com.telan.numbergame.game.param;

import com.telan.numbergame.domain.UserDO;
import com.telan.numbergame.param.GameBaseRequest;

/**
 * Created by weiwenliang on 17/5/29.
 */
public class OperateGameParam extends GameBaseRequest{
    private UserDO user;

    private Integer status;

    private Integer progress;

    private Long score;

    private String gameExtra;

    private Integer operateType;

    private Integer gameType;

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

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getGameExtra() {
        return gameExtra;
    }

    public void setGameExtra(String gameExtra) {
        this.gameExtra = gameExtra;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
    }

    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }
}
