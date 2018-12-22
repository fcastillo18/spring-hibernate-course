

select *
from instructor

select *
from instructor_detail

select *
from course

select *
from student

select *
from cbs.hlr_service
where trans_date >= getdate()-10


CREATE TABLE review (
  id int NOT NULL primary key identity,
  comment varchar(256) DEFAULT NULL,
  course_id int DEFAULT NULL,
  CONSTRAINT FK_COURSE_ID 
  FOREIGN KEY (course_id) REFERENCES course(id)  
) 

select *
from review

CREATE TABLE course_student (
  course_id int NOT NULL,
  student_id int NOT NULL,
  PRIMARY KEY (course_id,student_id),
  CONSTRAINT FK_COURSE_01
  FOREIGN KEY (course_id) REFERENCES course(id),
  CONSTRAINT FK_COURSE_02
  FOREIGN KEY (student_id) REFERENCES student(id)
)

CREATE INDEX IDX_COURSE_STUDENT ON course_student (student_id) 

select *
from course_student