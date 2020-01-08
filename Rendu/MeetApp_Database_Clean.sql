-- *********************************************
-- * SQL MySQL generation                      
-- *--------------------------------------------
-- * DB-MAIN version: 11.0.1              
-- * Generator date: Dec  4 2018              
-- * Generation date: Wed Nov 20 14:21:52 2019 
-- * Schema: db_meetapp
-- ********************************************* 

GRANT ALL PRIVILEGES ON *.* TO 'Buris'@'%' IDENTIFIED BY "root";

-- Database Section
-- ________________ 

create database db_meetapp;
use db_meetapp;


-- Tables Section
-- _____________ 

create table Participates (
     fkEvent int not null,
     fkUser int not null,
     parChance varchar(50) not null,
     constraint ID_Participates_ID primary key (fkUser, fkEvent));

create table t_evCategory (
     idCategory int not null AUTO_INCREMENT,
     catName varchar(255) not null,
     constraint ID_t_evCategory_ID primary key (idCategory));

create table t_event (
     idEvent int not null AUTO_INCREMENT,
     eveName varchar(255) not null,
     eveDescription varchar(1024) not null,
     evePicture varchar(255) not null,
     eveStartDatetime date not null,
     eveEndDatetime date not null,
     eveLocation varchar(255) not null,
     evePromoted char not null,
     evePrivate char not null,
     eveMaxUsers int not null,
     fkUser int not null,
     fkCategory int,
     constraint ID_t_event_ID primary key (idEvent));

create table t_user (
     idUser int not null AUTO_INCREMENT,
     useName varchar(255) not null,
     usePhoneNumber varchar(255) not null,
     usePwd varchar(255) not null,
     usePhoto varchar(255) not null,
     useBirthDate date not null,
     useJoinDate date not null,
     useKudos int not null,
     constraint ID_t_user_ID primary key (idUser));


-- Constraints Section
-- ___________________ 

alter table Participates add constraint FKPar_t_u
     foreign key (fkUser)
     references t_user (idUser);

alter table Participates add constraint FKPar_t_e_FK
     foreign key (fkEvent)
     references t_event (idEvent);

alter table t_event add constraint FKCreated_FK
     foreign key (fkUser)
     references t_user (idUser);

alter table t_event add constraint FKBelongs_FK
     foreign key (fkCategory)
     references t_evCategory (idCategory);


-- Index Section
-- _____________ 

create unique index ID_Participates_IND
     on Participates (fkUser, fkEvent);

create index FKPar_t_e_IND
     on Participates (fkEvent);

create unique index ID_t_evCategory_IND
     on t_evCategory (idCategory);

create unique index ID_t_event_IND
     on t_event (idEvent);

create index FKCreated_IND
     on t_event (fkUser);

create index FKBelongs_IND
     on t_event (fkCategory);

create unique index ID_t_user_IND
     on t_user (idUser);

