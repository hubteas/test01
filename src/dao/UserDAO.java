package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
   
}