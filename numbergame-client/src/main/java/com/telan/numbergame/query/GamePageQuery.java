package com.telan.numbergame.query;

import java.util.List;

/**
 * Created by weiwenliang on 2015/11/3.
 *
 */
public class GamePageQuery extends PageQuery {

    private static final long serialVersionUID = -3142728607169207697L;
    private List<Long> ids;

    private List<Integer> statusList;

    private Long userId;

    private Integer type;

    private Integer progress;

    private Long gameId;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<Integer> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Integer> statusList) {
        this.statusList = statusList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
