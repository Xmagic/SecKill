-- Create Database
CREATE DATABASE seckill;
-- Use the Database
use seckill;
-- Create Seckill table
CREATE TABLE seckill(
seckill_id bigint NOT NULL AUTO_INCREMENT COMMENT '��Ʒ���id',
name varchar(120) NOT NULL COMMENT '��Ʒ����',
number int NOT NULL COMMENT '�������',
start_time timestamp NOT NULL COMMENT '��ɱ��ʼʱ��',
end_time timestamp NOT NULL COMMENT '��ɱ����ʱ��',
create_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '����ʱ��',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 comment='��ɱ���';


-- Init data

insert into 
	seckill(name, number, start_time, end_time)
values
	('1000��ɱiphone6', 100, '2016-11-01 00:00:00', '2016-11-02 00:00:00'),
	('500��ɱipad2', 200, '2016-11-01 00:00:00', '2016-11-02 00:00:00'),
	('300��ɱС��4', 300, '2016-11-01 00:00:00', '2016-11-02 00:00:00'),
	('200��ɱ����note', 400, '2016-11-01 00:00:00', '2016-11-02 00:00:00');
	
	
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

	