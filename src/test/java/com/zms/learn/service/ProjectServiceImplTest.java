package com.zms.learn.service;


import com.zms.learn.common.TestContainers;
import com.zms.learn.service.impl.ProjectServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

@ComponentScan("com.zms.learn.dao")
@Import(ProjectServiceImpl.class)
public class ProjectServiceImplTest extends TestContainers {
    @Resource
    private ProjectService projectService;


    @DisplayName("新增项目测试")
    @Test
    void addProjectTest() {
        int i = projectService.addProject();
        Assertions.assertEquals(i, 1);
    }
}
