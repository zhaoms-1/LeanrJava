package com.zms.learn.service.user;


public interface UserInfoService {
    String getUser();

    default boolean isMan() {
        return true;
    }


    String getSchool();


}
