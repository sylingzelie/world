package com.sy.world.entity.claim;

/**
 * @description: 二元组
 * @author: caixuepu
 * @time: 2021/5/12
 */
public class TwoTuple<A, B> {
    public final A item1;
    public final B item2;

    public TwoTuple(A a, B b) {
        this.item1 = a;
        this.item2 = b;
    }
}
