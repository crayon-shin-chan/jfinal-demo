/* 插入三个用户u */
insert ignore into act_id_user (id_,pwd_) values ('zhangsan','123456'),('zongjian','123456'),('jingli','123456');
/* 插入用户组 */
insert ignore into act_id_group (id_,name_) values ('user','user_group'),('director','director_group'),('manager','manager_group');
/* 插入用户组关系数据 */
insert ignore into act_id_membership (user_id_,group_id_) values ('zhangsan','user'),('zongjian','director'),('jingli','manager');