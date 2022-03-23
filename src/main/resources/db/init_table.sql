create table IF not exists testA.project_task
(
    id            bigint auto_increment comment '自增主键'
        primary key,
    task_no       varchar(255) default ''                not null comment '项目单号',
    status        tinyint      default 0                 null comment '单据状态',
    qty           int          default 0                 null comment '数量',
    actual_qty    int          default 0                 null comment '完成数量',
    complete_time datetime                               null comment '项目完成时间',
    create_time   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    create_by     varchar(255) default ''                not null comment '创建人',
    update_by     varchar(255) default ''                null comment '更新人',
    del_flag      tinyint      default 0                 null comment '是否删除，0未删除 1已删除'
)
    comment '项目表' charset = utf8mb4;