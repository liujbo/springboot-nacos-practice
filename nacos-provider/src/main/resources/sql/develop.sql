-- tb_consumer 客户信息表
create table tb_consumer
(
    id                bigint auto_increment comment '自增主键' primary key,
    consumer_name     varchar(256) not null comment '客户姓名',
    consumer_birthday date         null comment '客户出生年月',
    consumer_gender   char         null comment '客户性别 0 女性，1 男性',
    consumer_address  varchar(256) null comment '客户地址',
    consumer_favorite text         null comment '客户喜好'
);