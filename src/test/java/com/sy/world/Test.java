package com.sy.world;

import com.sy.world.entity.LocalDateTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        LocalDateTest localDateTest1 = new LocalDateTest();
        LocalDateTest localDateTest2 = new LocalDateTest();
        LocalDateTest localDateTest3 = new LocalDateTest();
        List<LocalDateTest> list = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        localDateTest1.setName("sy2");
        localDateTest1.setNubmer(1);
        localDateTest1.setTime(now.minusDays(1));
        list.add(localDateTest1);
        localDateTest2.setName("sy1");
        localDateTest2.setNubmer(5);
        localDateTest2.setTime(LocalDateTime.now());
        list.add(localDateTest2);
        localDateTest3.setName("sy3");
        localDateTest3.setNubmer(6);
        localDateTest3.setTime(now.minusDays(2));
        list.add(localDateTest3);


        LocalDateTest localDateTest4 = new LocalDateTest();
        LocalDateTest localDateTest5 = new LocalDateTest();
        LocalDateTest localDateTest6 = new LocalDateTest();
        List<LocalDateTest> list1 = new ArrayList<>();
        localDateTest4.setName("sy4");
        localDateTest4.setNubmer(1);
        localDateTest4.setTime(now.minusDays(1));
        list1.add(localDateTest4);
        localDateTest5.setName("sy5");
        localDateTest5.setNubmer(2);
        localDateTest5.setTime(LocalDateTime.now());
        list1.add(localDateTest5);
        localDateTest6.setName("sy6");
        localDateTest6.setNubmer(3);
        localDateTest6.setTime(now.minusDays(2));
        list1.add(localDateTest6);

        List<LocalDateTest> collect = list.stream().sorted(Comparator.comparing(LocalDateTest::getTime).reversed()).collect(Collectors.toList());
        System.out.println(1);


        List<LocalDateTest> collect1 = list1.stream()
                .filter(card -> list.stream().anyMatch(r -> Objects.equals(r.getNubmer(), card.getNubmer())))
                .collect(Collectors.toList());
        System.out.println(1);
    }
}
