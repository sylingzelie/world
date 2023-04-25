package com.sy.world.enums;

import java.util.Objects;

public enum Mzbzzt {
    XS("1","享受"),
    BXS("2","不享受"),
    QX("3","取消资格");

    private String key;

    private String value;

    Mzbzzt(String key , String value){
        this.key = key;
        this.value = value;
    }

    public static String getValue(String key) {
        for (Mzbzzt t : values()) {
            if (Objects.equals(t.key, key)) {
                return t.value;
            }
        }
        return "未知";
    }
}
