package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBConnection;
import vo.UserDTO;


public class UserDAO {
   
   private Connection connection;
   private PreparedStatement preparedStatement;
   private ResultSet resultSet;
   

   public void dptData(UserDTO userDTO) {
	   String query = "INSERT INTO TBL_DEPARTMENT(department_id, department_name)"
	   		+ "VALUES (SEQ_TBL_DEPARTMENT.NEXTVAL, ?)";
		   
		   try {
			   connection = DBConnection.getConnection();
			   preparedStatement = connection.prepareStatement(query);
			   preparedStatement.setString(1, userDTO.getDepartmentName());
				   
			   preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("stuData() SQL오류");
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
   }
   
   public void addressData(UserDTO userDTO) {
	   String query = "INSERT INTO TBL_ADDRESS ta (address_id, address_postal_code, address_line1, address_line2)\r\n"
	   		+ "VALUES (SEQ_TBL_ADDRESS.NEXTVAL, ?,?,?)";
		   
		   try {
			   connection = DBConnection.getConnection();
			   preparedStatement = connection.prepareStatement(query);
			   preparedStatement.setString(1, userDTO.getAddressPostalCode());
			   preparedStatement.setString(2, userDTO.getAddressLine1());
			   preparedStatement.setString(3, userDTO.getAddressLine2());
				   
			   preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("stuData() SQL오류");
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
   }
   
   public void stuData(UserDTO userDTO) {
	   String query = "INSERT INTO TBL_STUDENT(student_id, student_name, student_age, department_id, address_id)"
	   		+ "VALUES (SEQ_TBL_STUDENT.NEXTVAL,?, ?, ?, ?)";
	   
	   try {
		   connection = DBConnection.getConnection();
		   preparedStatement = connection.prepareStatement(query);
		   preparedStatement.setString(1, userDTO.getStudentName());
		   preparedStatement.setInt(2, userDTO.getStudentAge());
		   preparedStatement.setString(3, userDTO.getDepartmentId());
		   preparedStatement.setString(4, userDTO.getAddressId());
			   
		   preparedStatement.executeUpdate();
	} catch (SQLException e) {
		System.out.println("stuData() SQL오류");
		e.printStackTrace();
	} finally {
		try {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
   }
   
//   4. 메소드 만들어서 진행할 것
//   - 학생 번호, 이름, 전공, 우편번호, 주소1, 주소2를 조회하기
   public  List<UserDTO> selectOne() {
	   String query = "SELECT STUDENT_ID, STUDENT_NAME, DEPARTMENT_NAME, address_line1, address_line2 "
	   		+ "FROM TBL_STUDENT ts, TBL_DEPARTMENT td, TBL_ADDRESS ta "
	   		+ "WHERE TS.DEPARTMENT_ID = TD.DEPARTMENT_ID  AND TS.ADDRESS_ID = TA.ADDRESS_ID ";
	   List<UserDTO> users = new ArrayList<>();
	   
	   try {
		   connection = DBConnection.getConnection();
		   preparedStatement = connection.prepareStatement(query);
		   resultSet = preparedStatement.executeQuery();
		   
	       while(resultSet.next()) {
	    	   UserDTO user = new UserDTO();
	    	   
	    	   user.setStudentId(resultSet.getInt(1));
	    	   user.setStudentName(resultSet.getString(2));
	    	   user.setDepartmentName(resultSet.getString(3));
	    	   user.setAddressLine1(resultSet.getString(4));
	    	   user.setAddressLine2(resultSet.getString(5));
	    	   
	    	   users.add(user);
	       }
	       
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	finally {
		try {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	   return users;
   }
//  - student 테이블의 나이가 22살인 학생들의 학과 정보 조회하기
   public List<UserDTO> selectAge(int studentAge){
	   String query = "SELECT TS.STUDENT_NAME, TD.DEPARTMENT_NAME "
	   		+ "FROM TBL_STUDENT ts , TBL_DEPARTMENT td "
	   		+ "WHERE TS.DEPARTMENT_ID = TD.DEPARTMENT_ID AND TS.STUDENT_AGE = ? ";
	   
	   List<UserDTO> users = new ArrayList<>();
	   try {
		connection = DBConnection.getConnection();
		   preparedStatement = connection.prepareStatement(query);
		   preparedStatement.setInt(1, studentAge);
		   resultSet = preparedStatement.executeQuery();
		   
		   while(resultSet.next()) {
             UserDTO user = new UserDTO();
             
             user.setStudentName(resultSet.getString(1));
             user.setDepartmentName(resultSet.getString(2));
           
             users.add(user);
	         }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	   return users;
   }
//  - 서울시 강남구에 사는 학생의 이름과 학과정보 조회하기
   public List<UserDTO> selectNameDpt(){
	   String query = "SELECT ts.STUDENT_NAME , td.DEPARTMENT_NAME "
	   		+ "FROM TBL_STUDENT ts , TBL_DEPARTMENT td, TBL_ADDRESS ta "
	   		+ "WHERE ts.DEPARTMENT_ID = td.DEPARTMENT_ID AND ts.ADDRESS_ID = ta.ADDRESS_ID AND ta.ADDRESS_LINE1 LIKE '%강남구%' ";
	   
	   List<UserDTO> users = new ArrayList<>();
	   
	   try {
		connection= DBConnection.getConnection();
		   preparedStatement=connection.prepareStatement(query);
		   resultSet = preparedStatement.executeQuery();
		   
		   while(resultSet.next()) {
			   UserDTO user = new UserDTO();
			   
			   user.setStudentName(resultSet.getString(1));
			   user.setDepartmentName(resultSet.getString(2));
			   
			   users.add(user);
		   }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(preparedStatement != null) {
				preparedStatement.close();
			}
			if(connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	   return users;
   }
//  - 맹구의 주소를 tbl_address테이블의 3번으로 수정하기

   
}