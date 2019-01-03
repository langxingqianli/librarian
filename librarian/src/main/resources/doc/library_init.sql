DROP TABLE IF EXISTS sys_user;

CREATE TABLE sys_user (
  user_id int(10) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  username varchar(200) COMMENT '用户姓名',
  password varchar(200) COMMENT '登陆密码',
  age int(10) COMMENT '年龄',
  sex varchar(50) COMMENT '性别；男-F 女—M',
  nickname varchar(100) COMMENT '用户昵称',
  usertype varchar(100) COMMENT '用户类型：普通用户-0 图书管理员-1',
  PRIMARY KEY (user_id)
) ENGINE=InnoDB CHARSET=utf8mb4;

/*Data for the table sys_user */

insert into sys_user(username,password,age,sex,nickname,usertype) values 
('mai','123456',18,'M','老花花',1);


DROP TABLE IF EXISTS sys_book;

CREATE TABLE sys_book (
  book_id int(10) NOT NULL AUTO_INCREMENT COMMENT '图书主键',
  book_name varchar(200) COMMENT '书名',
  author varchar(200) COMMENT '作者',
  publish varchar(50) COMMENT '性别；男-F 女—M',
  publish_date varchar(200) COMMENT '出版时间',
  page int(5) COMMENT '页数',
  price double(6,1) COMMENT '图书价格',
  content varchar(500) COMMENT '内容摘要',
  PRIMARY KEY (book_id)
) ENGINE=InnoDB CHARSET=utf8mb4;







