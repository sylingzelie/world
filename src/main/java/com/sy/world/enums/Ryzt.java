package com.sy.world.enums;

import java.util.Objects;

public enum Ryzt {
    ZZ("1","在职"),
    LZ("2","离职"),
    TX("3","退休"),
    LX("4","离休"),
    SW("5","死亡");

    private String key;

    private String value;

    Ryzt(String key ,String value){
        this.key = key;
        this.value = value;
    }

    public static String getValue(String key) {
        for (Ryzt t : values()) {
            if (Objects.equals(t.key, key)) {
                return t.value;
            }
        }
        return "未知";
    }
}
