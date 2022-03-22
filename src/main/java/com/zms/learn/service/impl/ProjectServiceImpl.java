package com.zms.learn.service.impl;

import com.zms.learn.dao.ProjectTaskMapper;
import com.zms.learn.modle.entity.project.ProjectTaskDO;
import com.zms.learn.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {
    @Resource
    private ProjectTaskMapper projectTaskMapper;

    @Override
    public int addProject() {
        ProjectTaskDO projectTaskDO = ProjectTaskDO.builder()
                .taskNo(UUID.randomUUID().toString().replace("-", ""))
                .status(0)
                .qty(0)
                .actualQty(0)
                .completeTime(null)
                .createBy("test")
                .updateBy("test")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        return projectTaskMapper.insert(projectTaskDO);
    }
}
