package pack04.odjbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Ex01_Test {
	
	//ojdbc : Oracle <-연결-> Java Database Connection..
	// DAO , DTO
	
	//Connection : 연결로를 만드는 객체(연결 객체)
	//PreparedStatement : 어떤 데이터를 전송하기 위한 객체(연결된 연결객체를 통해서 전달함)
	//ResultSet : 전송하고 나서 응답을 받으면 그 결과를 담는 객체(결과 객체)
	
	public static void main(String[] args) {
		Ex01_Test ex = new Ex01_Test();
		//ex.connTest();
		//ex.connTest2();
		ex.connTest3();
		
	}//main()
	
	//Connection : 연결로를 만드는 객체(연결 객체) 사용해서 통신되는지 체크
	
	public boolean connTest() {	//url, user, password, Ojdbc Class( 동적 로딩 : 자주 안씀 )
		
		//oracle.jdbc.driver.OracleDriver
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//필요한 드라이버를 동적으로 로딩함
			Connection conn = DriverManager.getConnection(url, user, password);
			if(conn.isClosed()) {	//is <= boolean을 리턴하는 네이밍룰
				System.out.println("닫힘");
			}else {
				System.out.println("열림");
				
				PreparedStatement ps = conn.prepareStatement(" select 1 num from dual ");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt("num"));	//<= 밑의 방법보단 상대적으로 안전함 
					System.out.println(rs.getInt(1));		//<= 많이 위험한 방식, 언제든지 index 바뀔 수 있음
				}//while
				
				
				conn.close();//통신이 열렸을 때 닫음※ 동시에 접속할 수 있는 숫자가 정해져 있음
				if(conn.isClosed()) System.out.println("닫힘(내가 닫음)");
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		}//try
		return false;
	}
	
	public boolean connTest2() {	//url, user, password, Ojdbc Class( 동적 로딩 : 자주 안씀 )
		
		//oracle.jdbc.driver.OracleDriver
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//필요한 드라이버를 동적으로 로딩함
			Connection conn = DriverManager.getConnection(url, user, password);
			if(conn.isClosed()) {	//is <= boolean을 리턴하는 네이밍룰
				System.out.println("닫힘");
			}else {
				System.out.println("열림");
				
				PreparedStatement ps = conn.prepareStatement(" select 'CSR' name from dual ");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString("name"));	//<= 밑의 방법보단 상대적으로 안전함 
					System.out.println(rs.getString(1));		//<= 많이 위험한 방식, 언제든지 index 바뀔 수 있음
				}//while
				
				
				
				conn.close();//통신이 열렸을 때 닫음※ 동시에 접속할 수 있는 숫자가 정해져 있음
				if(conn.isClosed()) System.out.println("닫힘(내가 닫음)");
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		}//try
		return false;
	}
	
	//scanner로 입력된 값을 sql문에 포함시켜서 보내고 조회해서 가져오기(Alias는 Result라고 하면 된다)
	
	public boolean connTest3() {	//url, user, password, Ojdbc Class( 동적 로딩 : 자주 안씀 )
		
		Scanner sc = new Scanner(System.in);
		System.out.print("SQL문을 입력하세요 : ");
		String name = sc.nextLine();
		
		//oracle.jdbc.driver.OracleDriver
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hanul";
		String password = "0000";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	//필요한 드라이버를 동적으로 로딩함
			Connection conn = DriverManager.getConnection(url, user, password);
			if(conn.isClosed()) {	//is <= boolean을 리턴하는 네이밍룰
				System.out.println("닫힘");
			}else {
				System.out.println("열림");
				
				PreparedStatement ps = conn.prepareStatement(" select '" + name + "' reuslt from dual ");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getString("reuslt"));	//<= 밑의 방법보단 상대적으로 안전함 
					System.out.println(rs.getString(1));		//<= 많이 위험한 방식, 언제든지 index 바뀔 수 있음
				}//while
				
				
				
				conn.close();//통신이 열렸을 때 닫음※ 동시에 접속할 수 있는 숫자가 정해져 있음
				if(conn.isClosed()) System.out.println("닫힘(내가 닫음)");
			}//if
		} catch (Exception e) {
			e.printStackTrace();
		}//try
		return false;
	
	
	}
	
	
	
}//class
