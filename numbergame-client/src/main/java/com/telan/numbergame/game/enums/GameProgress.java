package com.telan.numbergame.game.enums;

import java.util.ArrayList;
import java.util.List;

/**
 */
public enum GameProgress {
    PROCESS("进行中",2),
    SUCCESS("成功",3),
    FAILED("失败",4),
    ;
    private String desc;
    private int type;

    GameProgress(String desc, int type) {
        this.desc = desc;
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public int getType() {
        return type;
    }

    public static GameProgress getByType(int type) {
        for (GameProgress userType : values()) {
            if (userType.getType() == type) {
                return userType;
            }
        }
        return null;
    }

    public static GameProgress getByName(String name) {
        if (name == null) {
            return null;
        }
        for (GameProgress userType : values()) {
            if (userType.name().equals(name)) {
                return userType;
            }
        }
        return null;
    }

    public static GameProgress getByTypeWithDefault(int status) {
        for (GameProgress userType : values()) {
            if (userType.getType() == status) {
                return userType;
            }
        }
        return SUCCESS;
    }

    public static GameProgress getByNameWithDefault(String name) {
        if (name == null) {
            return SUCCESS;
        }
        for (GameProgress userType : values()) {
            if (userType.name().equals(name)) {
                return userType;
            }
        }
        return SUCCESS;
    }
}