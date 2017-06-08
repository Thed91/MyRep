CREATE DATABASE `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE test;
CREATE TABLE `user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `age` int(11) NOT NULL,
  `isAdmin` bit(1) NOT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into test.user(name,age,isAdmin) values ("Andey",20,0);
insert into test.user(name,age,isAdmin) values ("Vasya",22,1);
insert into test.user(name,age,isAdmin) values ("Tanya",2,0);
insert into test.user(name,age,isAdmin) values ("Petya",30,0);
insert into test.user(name,age,isAdmin) values ("Sveta",23,1);
insert into test.user(name,age,isAdmin) values ("Ilia",29,1);
insert into test.user(name,age,isAdmin) values ("Emma",60,1);
insert into test.user(name,age,isAdmin) values ("Olga",51,0);
insert into test.user(name,age,isAdmin) values ("Evgeny",45,1);
insert into test.user(name,age,isAdmin) values ("Elena",43,0);
insert into test.user(name,age,isAdmin) values ("Fedar",25,1);
insert into test.user(name,age,isAdmin) values ("Dima",37,0);
insert into test.user(name,age,isAdmin) values ("Dasha",25,1);
insert into test.user(name,age,isAdmin) values ("Sergy",29,1);
insert into test.user(name,age,isAdmin) values ("Sergy",31,0);
insert into test.user(name,age,isAdmin) values ("Toma",26,0);
