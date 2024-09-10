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
      department_id VARCHAR2(20),
      department_name VARCHAR2(20),
      CONSTRAINT PK_DEPARTMENT_ID PRIMARY KEY(DEPARTMENT_ID),
      CONSTRAINT UK_DEPARTMENT_NAME UNIQUE(DEPARTMENT_NAME)
);

CREATE TABLE TBL_ADDRESS(
      address_id VARCHAR2(20),
      address_postal_code VARCHAR2(20),
      address_line1 VARCHAR2(20),
      address_line2 VARCHAR2(20),
      CONSTRAINT PK_ADDRESS_ID PRIMARY KEY(ADDRESS_ID)

);

DROP TABLE TBL_ADDRESS;
DROP TABLE TBL_STUDENT;

CREATE TABLE tbl_student(
	  student_id NUMBER,
      student_name VARCHAR2(20),
      student_age NUMBER,
      department_id VARCHAR2(20),
      address_id VARCHAR2 (20),
      CONSTRAINT PK_STUDENT_ID PRIMARY KEY(STUDENT_ID),
      CONSTRAINT FK_DEPARTMENT_ID FOREIGN KEY(DEPARTMENT_ID)
      REFERENCES TBL_DEPARTMENT(DEPARTMENT_ID),
      CONSTRAINT FK_ADDRESS_ID FOREIGN KEY(ADDRESS_ID)
      REFERENCES TBL_ADDRESS(ADDRESS_ID)
);


