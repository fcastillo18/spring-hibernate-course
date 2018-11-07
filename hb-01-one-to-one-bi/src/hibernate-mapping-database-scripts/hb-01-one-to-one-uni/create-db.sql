/*
DROP SCHEMA IF EXISTS hb-01-one-to-one-uni;
CREATE SCHEMA hb-01-one-to-one-uni;
use hb-01-one-to-one-uni;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS instructor_detail;
*/

CREATE TABLE instructor_detail (
  id int NOT NULL identity primary key,
  youtube_channel varchar(128) NULL,
  hobby varchar(45) NULL,
) 

--DROP TABLE IF EXISTS instructor;

CREATE TABLE instructor (
  id int NOT NULL identity primary key,
  first_name varchar(45) NULL,
  last_name varchar(45) NULL,
  email varchar(45)  NULL,
  instructor_detail_id int,
  CONSTRAINT FK_INSTRUCTOR_DETAIL_ID 
  FOREIGN KEY (instructor_detail_id) 
  REFERENCES instructor_detail(id)
) 

