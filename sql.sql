create database if not exists question;
use question;
create table quser(
 id     int    primary key auto_increment,
 username varchar(20)
);

# 问题表
create table  question(
 id            int           primary key  auto_increment,
 title         varchar(200)  ,
 qtype          varchar(20)
);