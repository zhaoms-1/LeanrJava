package com.zms.learn.common;

import org.apache.commons.collections4.multiset.HashMultiSet;
import org.assertj.core.util.Lists;
import org.checkerframework.checker.units.qual.K;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.util.concurrent.ListenableFuture;
import org.testcontainers.shaded.com.google.common.collect.ArrayListMultimap;
import org.testcontainers.shaded.com.google.common.collect.ListMultimap;
import org.testcontainers.shaded.com.google.common.collect.Multimap;
import org.testcontainers.shaded.com.google.common.util.concurrent.FutureCallback;
import org.testcontainers.shaded.com.google.common.util.concurrent.Futures;
import org.testcontainers.shaded.com.google.common.util.concurrent.ListeningExecutorService;
import org.testcontainers.shaded.com.google.common.util.concurrent.MoreExecutors;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;


public class CommonCheck {
    @Test
    void nullCollection() {
        List list = null;
        List list1 = Optional.ofNullable(list).orElse(new ArrayList<>());
        System.out.println(list1);
    }

    @Test
    void commonCheck() {
        HashMultiSet<String> strings = new HashMultiSet<>();
        strings.add("1", 1);
        strings.add("1", 1);

        int count = strings.getCount("1");
        Assertions.assertEquals(2, count);
    }



    @Test
    void mapList() {
        Multimap<String, String> cars = ArrayListMultimap.create();

        Map<String, List<Integer>> collect = new HashMap<>();
        collect.put("1", List.of(1, 2));
        MultiValueMap<String, Integer> stringIntegerMultiValueMap = CollectionUtils.toMultiValueMap(collect);
        List<Integer> integers = stringIntegerMultiValueMap.get("1");
        Assertions.assertEquals(integers.size(), 2);
        stringIntegerMultiValueMap.forEach((k,v)->{

        });

        List emptyList = Collections.EMPTY_LIST;
    }

    @Test
    void ListenableFutureTest(){


    }
}
