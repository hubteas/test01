package util;

import java.sql.Connection;
import java.sql.SQLException;

import dao.UserDAO;
import vo.UserDTO;


public class Test {
	public static void insertAddress(String postalCode, String line1, String line2) {
		UserDTO userDTO = new UserDTO();
		UserDAO userDAO = new UserDAO();
		userDTO.setAddressPostalCode(postalCode);
		userDTO.setAddressLine1(line1);
		userDTO.setAddressLine2(line2);
		userDAO.addressData(userDTO);
		System.out.println(userDTO);
	}
	
	public static void insertDpt(String name) {
		UserDTO userDTO = new UserDTO();
		UserDAO userDAO = new UserDAO();
		userDTO.setDepartmentName(name);
		userDAO.dptData(userDTO);
		System.out.println(userDTO);
	}
	
	public static void insertStu(String name, int age, String dpt_id, String ads_id) {
		UserDTO userDTO = new UserDTO();
		UserDAO userDAO = new UserDAO();
		
		userDTO.setStudentName(name);
		userDTO.setStudentAge(age);
		userDTO.setDepartmentId(dpt_id);
		userDTO.setAddressId(ads_id);
		userDAO.stuData(userDTO);
		System.out.println(userDTO);
	}
   public static void main(String[] args) {
      
		try {
			Connection connection = DBConnection.getConnection();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		};
		
		UserDTO userDTO = new UserDTO();
		UserDAO userDAO = new UserDAO();
		
		userDAO.selectOne();
		userDAO.selectAge(22);
		userDAO.selectNameDpt();
		
		System.out.println(userDAO.selectOne());
		System.out.println(userDAO.selectAge(22));
		System.out.println(userDAO.selectNameDpt());
		
		//너무 없어보이니 메소드를 만들어준다
//		userDTO.setStudentName("짱구");
//		userDTO.setStudentAge(22);
//		userDTO.setDepartmentId("1");
//		userDTO.setAddressId("1");
		
//		userDTO.setAddressPostalCode("12345");
//		userDTO.setAddressLine1("123서울시강남구");
//		userDTO.setAddressLine2("아파트101");
		
//		userDTO.setAddressPostalCode("45678");
//		userDTO.setAddressLine1("456 서울시동남구");
//		userDTO.setAddressLine2("빌라202");
		
//		userDTO.setAddressPostalCode("56789");
//		userDTO.setAddressLine1("789서울시송파구");
//		userDTO.setAddressLine2("주택305");
		
//		userDTO.setDepartmentName("컴퓨터공학");
//		userDTO.setDepartmentName("인공지능학");
//		userDTO.setDepartmentName("정보보호학");
		
		
		//실행
//		insertAddress("12345", "123서울시강남구", "아파트101");
//		insertAddress("45678", "456 서울시 동작구", "빌라 202");
//		insertAddress("56789", "789 서울시 송파구", "주택 305");
//		insertDpt("컴퓨터공학");
//		insertDpt("인공지능학");
//		insertDpt("정보보호학");
//		insertStu("짱구", 22, "1", "1");
//		insertStu("철수", 21, "2", "2");
//		insertStu("맹구", 20, "1", "1");
//		insertStu("유리", 22, "3", "3");



		
      
   }
}
