package com.telan.numbergame.game.enums;

/**
 */
public enum GameType {
    FOUR_ARITHMETIC("四则运算",1),
    ;
    private String desc;
    private int type;

    GameType(String desc, int type) {
        this.desc = desc;
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public int getType() {
        return type;
    }

    public static GameType getByType(int type) {
        for (GameType userType : values()) {
            if (userType.getType() == type) {
                return userType;
            }
        }
        return null;
    }

    public static GameType getByName(String name) {
        if (name == null) {
            return null;
        }
        for (GameType userType : values()) {
            if (userType.name().equals(name)) {
                return userType;
            }
        }
        return null;
    }
}