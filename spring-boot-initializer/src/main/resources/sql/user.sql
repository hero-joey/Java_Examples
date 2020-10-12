create table t_user(
`t_id` int not null auto_increment,
`t_name` varchar(50),
`t_age` int,
primary key(`t_id`)
);

insert into t_user(t_name, t_age) values("Lucy", 25);
insert into t_user(t_name, t_age) values("Lily", 20);
insert into t_user(t_name, t_age) values("Jim", 20);