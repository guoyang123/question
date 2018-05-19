create database if not exists question;
use question;
create table quser(
 id     int    primary key auto_increment,
 username varchar(20)
);

# 问题表,题库
drop table if EXISTS question;
create table  question(
 qid            int           primary key  auto_increment,
 title         varchar(200)  ,
 qtype          varchar(20),
 qno           VARCHAR (30) not null -- 问卷编号
);
#问卷信息表
create table qinfo(
 id              int       PRIMARY key auto_increment,
 qno             varchar(30)  not null, -- 问卷编号
 qtitle         varchar(200)  not null ,-- 问卷标题
 qdesc          varchar(200)  , -- 问卷描述
 userid          int       -- 该user创建此问卷
);
# 答案表
drop table if exists qanswer;
create table qanswer(
id            int                PRIMARY  key  auto_increment,
qid           int              ,-- 问题id
qtitle         varchar(200)    , -- 问题标题
qno            varchar(30)     , -- 问卷编号
answer        varchar(200)     , -- 问题答案
answertime    VARCHAR (20)     , -- 提交时间
userip        varchar(30)       -- ip
);
