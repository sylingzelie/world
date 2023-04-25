package com.sy.world.enums;

import java.util.Objects;

public enum Bcylcbzt {
    CB("1","参保"),
    WCB("2","未参保"),
    ZZ("3","中止"),
    XH("4","销户");

    private String key;

    private String value;

    Bcylcbzt(String key , String value){
        this.key = key;
        this.value = value;
    }

    public static String getValue(String key) {
        for (Bcylcbzt t : values()) {
            if (Objects.equals(t.key, key)) {
                return t.value;
            }
        }
        return "未知";
    }
}
