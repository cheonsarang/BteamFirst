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
	PreparedStatement ps;
	ResultSet rs;
	
	//Connection
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
		String user = "hanul";
		String password = "0000";
		
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
			}
			if (ps != null) {
				ps.close();// 2
			}
			if (conn != null) {
				conn.close();// 1
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("error");
		}//try
	}//dbClose()
	
	public void selectOne() {
		getConn();
		String sql = "SELECT 1 as num1 FROM dual";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
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
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getFirst_name());
			ps.setString(2, dto.getLast_name());
			ps.setInt(3, dto.getStudent_no());
			ps.setString(4, dto.getUser_id());
			return ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("업데이트 에러");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return 1;
	}
	
	//회원정보 삭제
	public int delete(String student_no, String user_id) {
		conn = getConn();
		int a=0;
		String sql = "DELETE FROM user_info WHERE student_no = ? AND user_id= ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, student_no);
			ps.setString(2, user_id);
			a = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("delete error!");
			e.printStackTrace();
		}finally {
			dbClose();
		}
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
