package com.zms.learn.service;


import com.zms.learn.common.DatabaseBaseTest;
import com.zms.learn.service.projectService.impl.ProjectServiceImpl;
import com.zms.learn.service.projectService.ProjectService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@ActiveProfiles("mariadb")
@SpringBootTest
@MapperScan("com.zms.learn.dao")
@Import(ProjectServiceImpl.class)
@ExtendWith(SpringExtension.class)
public class ProjectServiceImplTest extends DatabaseBaseTest {
    @Resource
    private ProjectService projectService;


    @DisplayName("新增项目测试")
    @Test
    void addProjectTest() {
        int i = projectService.addProject();
        Assertions.assertEquals(i, 1);
    }

}
