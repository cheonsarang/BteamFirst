package emp;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import customer.customerDTO;

public class empDAO {
	static SqlSession sql;
	static {
		String resource = "mybatis/config1.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession(true); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<DTO> getList(){
		List<DTO> list = sql.selectList("cus.emp");
		return list;
	}
}
