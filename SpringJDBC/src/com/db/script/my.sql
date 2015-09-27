CREATE TABLE Student(
   ID   NUMBER NOT NULL ,
   NAME VARCHAR(20) NOT NULL,
   AGE  NUMBER NOT NULL,
   PRIMARY KEY (ID)
);



CREATE OR REPLACE PROCEDURE getRecord(in_id IN NUMBER ,out_name OUT VARCHAR2,out_age OUT NUMBER) 
IS    
  BEGIN    
  SELECT name, age
  INTO out_name, out_age
  FROM Student where id = in_id;
END; 