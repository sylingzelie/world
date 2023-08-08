package com.sy.world.entity;

import lombok.Data;
import lombok.NonNull;

import java.util.List;


@Data
public class Order {

    private List<r> e;

    @Data
    public static class r{
        @NonNull
        private String number;
    }
}