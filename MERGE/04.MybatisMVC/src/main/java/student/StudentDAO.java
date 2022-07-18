package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class StudentDAO {
	Connection conn;
<<<<<<< HEAD
	PreparedStatement ps; //질의문객체
	ResultSet rs ;
=======
	PreparedStatement ps;
	ResultSet rs;
	
	//Connection
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
<<<<<<< HEAD
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn Error !");
		}
		return conn;
	}

	public void dbClose() {
		try { 
			if (rs != null) {
				rs.close();
=======
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getConn Error!");
		}//try
		return conn;
	}//getConn()
	
	//DB닫기
	public void dbClose() {
	// 통신을 열때랑 역순으로 닫아주면 된다. 
		try { // == < 참조를 시작했는지를 알수있는
			if (rs != null) {
				rs.close();// 3 ?
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
			}
			if (ps != null) {
				ps.close();// 2
			}
			if (conn != null) {
				conn.close();// 1
			}
		} catch (SQLException e) {
			e.printStackTrace();
<<<<<<< HEAD
		}

	}

	public void selectOne() {
		getConn();
		String sql = " select 1 as num1 from dual ";
=======
			System.out.println("error");
		}//try
	}//dbClose()
	
	public void selectOne() {
		getConn();
		String sql = "SELECT 1 as num1 FROM dual";
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
<<<<<<< HEAD
				System.out.println(rs.getInt("num1"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
	}
	//수동↓
	public ArrayList<StudentDTO> getManualLIst(){
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		for (int i = 0; i < 10; i++) {
			list.add(new StudentDTO("a", "b", "c", "d", "e", i));
		}
		return list;
	}
	//실제 있는 데이터를 가져오는 getList라는 메소드를 만들고 해당하는 메소드를 이용해서
	//실제 데이터를 활용하기
	
	public ArrayList<StudentDTO> getLIst(){
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		getConn();
		String sql = "SELECT u.* , s.student_name "
				+ " FROM USER_INFO u left outer join STUDENT s on u.STUDENT_NO = s.STUDENT_NO";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while(rs.next()) {
				list.add(new StudentDTO(
						rs.getString("student_name"), 
						rs.getString("user_id"), 
						rs.getString("user_pw"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getInt("student_no")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		return list;
	}
	// HttpServletRequest req = Controller.req;
	// String abc = Controller."";
	// 1 .String student_no , user_id ; ☆☆☆★★★★★
	public StudentDTO getStudentInfo(String student_no , String user_id) {// 해당하는 메소드가 실행될때 필요한 변수를 어떤곳에 입력받아서 사용하기.
		StudentDTO dto = null;
		getConn();
		String sql = " SELECT u.* , s.student_name  FROM USER_INFO u left outer join STUDENT s on u.STUDENT_NO = s.STUDENT_NO "
				+ " where  u.STUDENT_NO= ? AND u.USER_ID=? ";
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, student_no);
			ps.setString(2, user_id);
			
		//	ps.setString(1, req.getParameter("studentno")); req를 이용하면 항상 req.getparamter가 있는경우에만 이용이가능
														  //재활용이나 여러 플랫폼에서 활용하기엔 불편함
		//	ps.setString(2, req.getParameter("user_id"));
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new StudentDTO(
						rs.getString("student_name"), 
						rs.getString("user_id"), 
						rs.getString("user_pw"), 
						rs.getString("first_name"), 
						rs.getString("last_name"), 
						rs.getInt("student_no")
						);
				dto.setAdmin_yn(rs.getString("admin_yn"));
				dto.setMoney(rs.getInt("money"));
				dto.setCreate_ymd(rs.getString("create_ymd"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//데이터베이스에 접근해서 학생 한명의 정보를 얻어오는 비지니스로직을 구현(데이터 한건 얻어오기)
		
		return dto;
	}

	public int modifyInfo(StudentDTO dto) {
		getConn();
		String sql = " UPDATE USER_INFO "
				+ "SET FIRST_NAME = ?, LAST_NAME=? "
				+ "WHERE STUDENT_NO = ? and  USER_ID=?  " ; 
=======
				System.out.println(rs.getInt("NUM1"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}//try
	}//selectOne()
	
	//DB ArrayList로 받아오기
	public ArrayList<StudentDTO> getList(){
		ArrayList<StudentDTO> list = new ArrayList<>();
		conn = getConn(); 
		String sql = "SELECT s.student_name, U.* FROM user_info U LEFT OUTER JOIN student S ON u.student_no = s.student_no";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				StudentDTO dto = new StudentDTO(
						rs.getString("STUDENT_NAME"),
						rs.getString("USER_ID"),
						rs.getString("USER_PW"),
						rs.getString("FIRST_NAME"),
						rs.getString("LAST_NAME"),
						rs.getInt("STUDENT_NO"));
				list.add(dto);
				//list.add(new StudentDTO(rs.getString(), ...))
			}//while
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getList error!");
		} finally {
			dbClose();
		}
		return list;
	}//getList()
	
	//한 건의 정보를 받아오기 위한 메소드 HttpServletRequest req 사용 가능
	public StudentDTO getStudentInfo(int num, String id) {
	//int, String를 쓰는 게 더 낫다 이유? 재활용이 가능하다
	//request는 사용 가능한 곳이 따로 있음
	//req를 이용하면 항상 req.getParameter가 있는 경우에만 이용가능.
	//재활용이나 여러 플랫폼에서 활용하기엔 불편함
	//public StudentDTO getStudentInfo(HttpServletRequest req) {
		 //StudentDTO dto = new StudentDTO();
		StudentDTO dto = null;
		conn = getConn();
		
		String sql = "SELECT s.student_name, u.* FROM user_info u ";
		sql += " LEFT OUTER JOIN student s ON u.student_no = s.student_no";
		sql += " WHERE u.student_no = ? AND u.user_id= ?";
		
		try {
			ps = conn.prepareStatement(sql);
			//ps.setInt(1, Integer.parseInt(req.getParameter("student_no")));
			//ps.setString(1, req.getParameter("student_no"));
			//ps.setString(2, req.getParameter("user_id"));
			
			ps.setInt(1, num);
			ps.setString(2, id);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				dto = new StudentDTO(
						rs.getString("STUDENT_NAME"),
						rs.getString("USER_ID"),
						rs.getString("USER_PW"),
						rs.getString("FIRST_NAME"),
						rs.getString("LAST_NAME"),
						rs.getInt("STUDENT_NO"));
				dto.setAdmin_yn(rs.getString("ADMIN_YN"));
				dto.setMoney(rs.getInt("MONEY"));
				dto.setCreate_ymd(rs.getString("create_ymd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getList error!");
		} finally {
			dbClose();
		}
		return dto;
	}
	
	//수정하기1
	public int modify(String first_name, String last_name, int student_no, String user_id) {
		getConn();
		String sql = "UPDATE user_info SET first_name = ?, last_name = ? WHERE student_no = ? AND user_id = ?";
		int a=0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ps.setInt(3, student_no);
			ps.setString(4, user_id);
			a= ps.executeUpdate();
			System.out.println(a);
		} catch (Exception e) {
			System.out.println("업데이트 에러");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return a;
	}//updateInfo()
	
	//수정하기2
	public int modifyInfo(StudentDTO dto) {
		getConn();
		String sql = "UPDATE user_info SET first_name = ?, last_name = ? WHERE student_no = ? AND user_id = ?";
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getFirst_name());
			ps.setString(2, dto.getLast_name());
			ps.setInt(3, dto.getStudent_no());
			ps.setString(4, dto.getUser_id());
			return ps.executeUpdate();
<<<<<<< HEAD
			
		} catch (SQLException e) {
=======
		} catch (Exception e) {
			System.out.println("업데이트 에러");
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
			e.printStackTrace();
		}finally {
			dbClose();
		}
<<<<<<< HEAD
		
		return 0;
	}

	public int deleteInfo(String student_no, String user_id) {
		getConn();
		String sql = "  DELETE FROM USER_INFO WHERE student_no = ? AND user_id=?"; 
=======
		return 1;
	}
	
	//회원정보 삭제
	public int delete(String student_no, String user_id) {
		conn = getConn();
		int a=0;
		String sql = "DELETE FROM user_info WHERE student_no = ? AND user_id= ? ";
		
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, student_no);
			ps.setString(2, user_id);
<<<<<<< HEAD
			
			
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
=======
			a = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete error!");
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
			e.printStackTrace();
		}finally {
			dbClose();
		}
<<<<<<< HEAD
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
=======
		return a;
	}//delete
	
	//로그인 메소드 작성
	public void login() {
		conn = getConn();
		ArrayList<StudentDTO> list = getList();
		//내가 하고 싶은데 하고 싶은 방식이 있는데
		//가지고 온거랑 비교하고 싶다
		//어떻게 가지고 올 것인가
		//어떻게 비교를 할 것인가/
	}//login()
	
	//ArrayList<StudentDTO>를 10건 리턴하는 메소드 작성
	//getManualList();
	
	//접근제한자 리턴타입 메소드이름(){
	//}
	public ArrayList<StudentDTO> getManualList(){

		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		
		for (int i = 0; i < 10; i++) {
			list.add(new StudentDTO("AHE", "A", "1234", "A", "A", i));
			//StudentDTO dto = new StudentDTO(null, null, null, null, null, i);
			//list.add(dto);
		}//for
		return list;
	}//getManualList

}//class
>>>>>>> 70784f47a1ca820634f3635bbd19b0dfea3848c0
