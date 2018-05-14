create database if not exists question;
use question;
create table quser(
 id     int    primary key auto_increment,
 username varchar(20)
);

# 问题表,题库
create table  question(
 id            int           primary key  auto_increment,
 title         varchar(200)  ,
 qtype          varchar(20)
);
#问卷信息表
create table qinfo(
 id              int       PRIMARY key auto_increment,
 qno             varchar(30)  not null, -- 问卷编号
 qtitle         varchar(200)  not null ,-- 问卷标题
 qdesc          varchar(200)  , -- 问卷描述
 userid          int       -- 该user创建此问卷
);