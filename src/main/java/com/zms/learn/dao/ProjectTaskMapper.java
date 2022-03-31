package com.zms.learn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zms.learn.modle.entity.project.ProjectTaskDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectTaskMapper extends BaseMapper<ProjectTaskDO> {
}
