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
	
	//ArrayList<StudentDTO> 를 10건 리턴하는 메소드 작성
	// getManualList();
	// 접근제한자 리턴타입 메소드이름(){
	// }
	
	//수동으로 한 것
	public ArrayList<StudentDTO> getManualLIst(){
		ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
		for (int i = 0; i < 10; i++) {
			list.add(new StudentDTO("a", "b", "c", "d", "e", i));
		}
		return list;
	}
	
	//실제데이터 활용
	public ArrayList<StudentDTO> getList() {
		conn = getConn();
		ArrayList<StudentDTO> list = new ArrayList<>();
		String sql = "SELECT  s.student_name, u.user_id, u.user_pw, u.first_name, u.last_name, u.student_no"
				+ " FROM    user_info u left outer join student s on u.student_no = s.student_no";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new StudentDTO(rs.getString("student_name"), rs.getString("user_id"), rs.getString("user_pw"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getInt("student_no")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		System.out.println(list.size());
		return list;
	}
	
	//연결
		public Connection getConn() {
			String url = "jdbc:oracle:thin:@221.144.89.105:3301:XE";
			String user = "hanul";
			String password = "0000";
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("getConn Error !");
			}//try
			return conn;
		}//getConn()
		
	//디비 연결 끊기
	public void dbClose() {
		try { 
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//dbClose()
	
	public void selectOne() {
		getConn();
		String sql = " select 1 as num1 from dual ";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("num1"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
				e.printStackTrace();
			}
			//데이터베이스에 접근해서 학생 한명의 정보를 얻어오는 비지니스로직을 구현(데이터 한건 얻어오기)
			
			return dto;
		}
	
}
