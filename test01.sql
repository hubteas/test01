--2. 해당 계정으로 테이블을 만들고 jdbc 이용하여 연결 진행
--   테이블명 : tbl_student
--   컬럼   
--      student_id (PK)
--      student_name
--      student_age
--      department_id (FK)
--      address_id (FK)
--
--   테이블명 : tbl_department
--   컬럼
--      department_id (PK)
--      department_name unique
--   
--   테이블명 : tbl_address
--   컬럼
--      address_id (PK)
--      address_postal_code
--      address_line1

CREATE TABLE TBL_DEPARTMENT(
      department_id VARCHAR2(40),
      department_name VARCHAR2(40),
      CONSTRAINT PK_DEPARTMENT_ID PRIMARY KEY(DEPARTMENT_ID),
      CONSTRAINT UK_DEPARTMENT_NAME UNIQUE(DEPARTMENT_NAME)
);

CREATE TABLE TBL_ADDRESS(
      address_id VARCHAR2(40),
      address_postal_code VARCHAR2(40),
      address_line1 VARCHAR2(40),
      address_line2 VARCHAR2(40),
      CONSTRAINT PK_ADDRESS_ID PRIMARY KEY(ADDRESS_ID)

);

DROP TABLE TBL_ADDRESS CASCADE CONSTRAINTS;
DROP TABLE TBL_STUDENT CASCADE CONSTRAINTS;
DROP TABLE tbl_department CASCADE CONSTRAINTS;;

CREATE TABLE tbl_student(
	  student_id NUMBER,
      student_name VARCHAR2(40),
      student_age NUMBER,
      department_id VARCHAR2(40),
      address_id VARCHAR2 (40),
      CONSTRAINT PK_STUDENT_ID PRIMARY KEY(STUDENT_ID),
      CONSTRAINT FK_DEPARTMENT_ID FOREIGN KEY(DEPARTMENT_ID)
      REFERENCES TBL_DEPARTMENT(DEPARTMENT_ID),
      CONSTRAINT FK_ADDRESS_ID FOREIGN KEY(ADDRESS_ID)
      REFERENCES TBL_ADDRESS(ADDRESS_ID)
);

--3. tbl_student, tbl_department, tbl_address 데이터를 아래 값으로 추가하기(PreparedStatement 사용)
--   tbl_student
--      1, 짱구, 22, 1 (컴퓨터공학), 1 (123 서울시 강남구)
--      2, 철수, 21, 2 (인공지능학), 2 (456 서울시 동작구)
--      3, 맹구, 20, 1 (컴퓨터공학), 1 (123 서울시 강남구)
--      4, 유리, 22, 3 (정보보호학), 3 (789 서울시 송파구)
--   tbl_department
--      1, 컴퓨터공학
--      2, 인공지능학
--      3, 정보보호학
--   tbl_address
--      1, 12345, 123 서울시 강남구, 아파트 101
--      2, 45678, 456 서울시 동작구, 빌라 202
--      3, 56789, 789 서울시 송파구, 주택 305

CREATE SEQUENCE SEQ_TBL_STUDENT
INCREMENT BY 1;
DROP SEQUENCE seq_tbl_student;
CREATE SEQUENCE SEQ_TBL_DEPARTMENT
INCREMENT BY 1;
DROP SEQUENCE seq_tbl_address;
CREATE SEQUENCE SEQ_TBL_ADDRESS
INCREMENT BY 1;

INSERT INTO TBL_STUDENT(student_id, student_name, student_age, department_id, address_id)
VALUES (SEQ_TBL_STUDENT.NEXTVAL,'짱구', 22, '1', '1');

INSERT INTO TBL_DEPARTMENT(department_id, department_name)
VALUES (SEQ_TBL_DEPARTMENT.NEXTVAL, "컴퓨터공학");

INSERT INTO TBL_ADDRESS ta (address_id, address_postal_code, address_line1, address_line2)
VALUES (SEQ_TBL_ADDRESS.NEXTVAL, ?,?,?);

DELETE FROM TBL_STUDENT;
DELETE FROM TBL_ADDRESS
WHERE address_id = '4' || address_id = '5';

