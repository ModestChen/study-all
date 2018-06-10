drop database if exists mybatis;

create database mybatis;

use mybatis;

CREATE TABLE student (
  id varchar(255) NOT NULL COMMENT 'id',
  name varchar(16) DEFAULT NULL COMMENT '姓名',
  age varchar(2) DEFAULT NULL COMMENT '年龄',
  sex varchar(2) DEFAULT NULL COMMENT '性别',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;