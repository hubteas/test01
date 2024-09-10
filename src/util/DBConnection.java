package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
   public static Connection getConnection() {
      Connection connection = null;
      try {

         String userName = "web5";
         String password = "0910";
         String url = "jdbc:oracle:thin:@localhost:1521:XE";
         

         Class.forName("oracle.jdbc.OracleDriver");

         connection = DriverManager.getConnection(url, userName, password);
         
         System.out.println("연결 성공");
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
         System.out.println("드라이버 로딩 실패");
      } catch (SQLException e) {
         e.printStackTrace();
         System.out.println("연결 실패");
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("알 수 없는 오류");
      }
      
      return connection;
   }
   

   public static void close(Connection con, PreparedStatement pstm, ResultSet rs) throws SQLException  {
      
         if(rs != null) {
            rs.close();
         }
         if(pstm != null) {
            pstm.close();
         }
         if(con != null) {
            con.close();
         }
   }
   
   // select 제외 사용한 객체들 close

   public static void close(Connection con, PreparedStatement pstm) throws SQLException  {
	      
	      if(pstm != null) {
	         pstm.close();
	      }
	      if(con != null) {
	         con.close();
	      }
	   
	   
	}
}
   