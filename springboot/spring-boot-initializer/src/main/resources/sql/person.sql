use test;
create table t_id_card(
`id` int primary key auto_increment,
`code` varchar(18)
);

INSERT INTO t_id_card(code) VALUES('152221198711020624');
INSERT INTO t_id_card(code) VALUES('152201199008150317');

drop table  if exists t_person;
create table t_person(
`id` int primary key auto_increment,
`name` varchar(32),
`age` int,
`sex` varchar(8),
`card_id` int unique,
foreign key(`card_id`) references t_id_card(`id`)
)engine=InnoDb DEFAULT CHARSET=utf8mb4 comment='人员表';
INSERT INTO t_person(name , age , sex , card_id) VALUES('Rose', 29 , '女', 1) ;
INSERT INTO t_person(name , age , sex , card_id) VALUES('Tom', 27, '男', 2) ;

show create table t_person;

