create table t_nb_user (
`id` int(32) primary key auto_increment,
`username` varchar(32),
`address` varchar(256)
)engine=InnoDb DEFAULT CHARSET=utf8mb4 comment='用户表';

insert into t_nb_user values('1', '詹姆斯', '克里兰夫');
insert into t_nb_user values('2', '科比', '洛杉矶');
insert into t_nb_user values('3', '保罗', '洛杉矶');

create table t_nb_orders (
 `id` int(32) primary key auto_increment,
 `number` varchar(32) not null,
 `user_id` int(32) not null,
 foreign key(`user_id`) references t_nb_user(`id`)
)engine=InnoDb DEFAULT CHARSET=utf8mb4 comment='订单表';

insert into t_nb_orders values('1', '100000001', '1');
insert into t_nb_orders values('2', '100000012', '1');
insert into t_nb_orders values('3', '100000013', '3');