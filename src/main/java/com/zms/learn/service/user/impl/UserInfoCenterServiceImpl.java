package com.zms.learn.service.user.impl;

import com.zms.learn.service.user.PassportService;
import com.zms.learn.service.user.UserInfoCenterService;
import com.zms.learn.service.user.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

@Service
public class UserInfoCenterServiceImpl implements UserInfoCenterService {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private PassportService passportService;

    @Autowired
    @Qualifier("schedule")
    private Executor executor;

    @Override
    public List getUserInfoById(Long id) throws ExecutionException, InterruptedException {
        List<String> arrayList = new ArrayList<String>();
        long s = System.currentTimeMillis();
        var user = CompletableFuture.supplyAsync(() -> userInfoService.getUser(), executor).thenApply(arrayList::add);
        var school = CompletableFuture.supplyAsync(() -> userInfoService.getSchool(), executor).thenApply(arrayList::add);
        var passport = CompletableFuture.supplyAsync(() -> passportService.getPassport(), executor).thenApply(arrayList::add);
        CompletableFuture.allOf(user, school, passport).get();
        long e = System.currentTimeMillis();
        System.out.println("耗时:" + (e - s));


        return arrayList;
    }
}
