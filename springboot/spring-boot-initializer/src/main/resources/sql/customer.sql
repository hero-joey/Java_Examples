create database test;
use test;
create table t_customer (
`id` int(32) auto_increment,
`username` varchar(50),
`job` varchar(50),
`phone` varchar(16),
primary key(`id`)
)engine=Innodb;
insert into t_customer values('1', 'Joy', 'doctor', '15928927075');
insert into t_customer values('2', 'Jack', 'teacher', '13926578932');
insert into t_customer values('3', 'Tom', 'worker', '15207498632');
