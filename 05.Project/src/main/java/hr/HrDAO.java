package hr;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class HrDAO {

	public static SqlSession sql;
	static {

		try {
			String resource = "mybatis/hr-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession(true);	//AutoCommit설정을 true
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<EmpDTO> getEmpList(){
		
		return sql.selectList("hr.emplist");

	}
	
	public List<DeptDTO> getDepList(){
		
		return sql.selectList("hr.deptlist");
	}
	
	
	
	
}
