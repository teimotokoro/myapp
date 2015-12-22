# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table course (
  id                        bigint auto_increment not null,
  course_name               varchar(255),
  course_description        varchar(255),
  constraint pk_course primary key (id))
;

create table course_execution (
  id                        bigint auto_increment not null,
  start_date                datetime,
  days                      integer,
  cost_per_day              float,
  course_id                 bigint,
  constraint pk_course_execution primary key (id))
;

create table person (
  id                        bigint auto_increment not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  middle_initial            varchar(255),
  constraint pk_person primary key (id))
;


create table course_execution_person (
  course_execution_id            bigint not null,
  person_id                      bigint not null,
  constraint pk_course_execution_person primary key (course_execution_id, person_id))
;
alter table course_execution add constraint fk_course_execution_course_1 foreign key (course_id) references course (id) on delete restrict on update restrict;
create index ix_course_execution_course_1 on course_execution (course_id);



alter table course_execution_person add constraint fk_course_execution_person_course_execution_01 foreign key (course_execution_id) references course_execution (id) on delete restrict on update restrict;

alter table course_execution_person add constraint fk_course_execution_person_person_02 foreign key (person_id) references person (id) on delete restrict on update restrict;

# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table course;

drop table course_execution;

drop table course_execution_person;

drop table person;

SET FOREIGN_KEY_CHECKS=1;

