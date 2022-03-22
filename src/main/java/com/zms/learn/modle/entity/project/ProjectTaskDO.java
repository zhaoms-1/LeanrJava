package com.zms.learn.modle.entity.project;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.zms.learn.modle.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.SuperBuilder;


/**
 * 项目表
 * @TableName project_task
 */
@TableName(value ="project_task")
@Data
@SuperBuilder
public class ProjectTaskDO extends BaseEntity implements Serializable {

    /**
     * 项目单号
     */
    private String taskNo;

    /**
     * 单据状态
     */
    private Integer status;

    /**
     * 数量
     */
    private Integer qty;

    /**
     * 完成数量
     */
    private Integer actualQty;

    /**
     * 项目完成时间
     */
    private Date completeTime;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;



}