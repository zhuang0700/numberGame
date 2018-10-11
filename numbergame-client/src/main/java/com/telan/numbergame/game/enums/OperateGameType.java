package com.telan.numbergame.game.enums;

/**
 */
public enum OperateGameType {
    UPDATE_PROGRESS("更新进度",1),
    FINISH_GAME("完成游戏",2),
    ;
    private String desc;
    private int type;

    OperateGameType(String desc, int type) {
        this.desc = desc;
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public int getType() {
        return type;
    }

    public static OperateGameType getByType(int type) {
        for (OperateGameType userType : values()) {
            if (userType.getType() == type) {
                return userType;
            }
        }
        return null;
    }

    public static OperateGameType getByName(String name) {
        if (name == null) {
            return null;
        }
        for (OperateGameType userType : values()) {
            if (userType.name().equals(name)) {
                return userType;
            }
        }
        return null;
    }
}