-- Create Database
CREATE DATABASE seckill;
-- Use the Database
use seckill;
-- Create Seckill table
CREATE TABLE seckill(
seckill_id bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
name varchar(120) NOT NULL COMMENT '商品名称',
number int NOT NULL COMMENT '库存数量',
start_time timestamp NOT NULL COMMENT '秒杀开始时间',
end_time timestamp NOT NULL COMMENT '秒杀结束时间',
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='秒杀库存';


-- Init data

insert into 
	seckill(name, number, start_time, end_time)
values
	('1000秒杀iphone6', 100, '2016-11-01 00:00:00', '2016-11-02 00:00:00'),
	('500秒杀ipad2', 200, '2016-11-01 00:00:00', '2016-11-02 00:00:00'),
	('300秒杀小米4', 300, '2016-11-01 00:00:00', '2016-11-02 00:00:00'),
	('200秒杀红米note', 400, '2016-11-01 00:00:00', '2016-11-02 00:00:00');
	
	
--Sec kill success details table
create table success_killed(
seckill_id bigint NOT NULL COMMENT 'SECKILL ID',
user_phone bigint NOT NULL COMMENT 'phone number',
state tinyint NOT NULL DEFAULT -1 COMMENT 'state of item: -1:invalid 0:success 1 :paid',
create_time timestamp NOT NULL COMMENT 'createTime',
PRIMARY KEY (seckill_id, user_phone) /*Unin Key*/
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='seckill success details table';

-- connect to database console

mysql -uroot -p123456

	