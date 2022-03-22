package com.zms.learn.modle.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
public class BaseEntity {
    /**
     * 自增主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 更新人
     */
    private String updateBy;


    /**
     * 是否删除，0未删除 1已删除
     */
    @TableLogic
    private Integer delFlag;
}
