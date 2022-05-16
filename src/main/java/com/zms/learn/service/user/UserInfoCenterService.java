package com.zms.learn.service.user;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface UserInfoCenterService {
    List getUserInfoById(Long id) throws ExecutionException, InterruptedException;
}
