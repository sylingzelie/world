package com.sy.world.tools;

import com.sy.world.entity.Order;
import com.sy.world.entity.User;

public class TestImpl implements TestT{

    @Override
    public Object compareTo() {
        User user = new User();
        user.setUsername("sy");
        Order order = new Order();
        order.setNumber("123");
        int random = (int)Math.random()*10;
        if(random > 5){
            return user;
        }else {
            return order;
        }
    }
}
