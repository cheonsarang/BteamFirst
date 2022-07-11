package emp;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpDAO {
	
	private static SqlSession sql;
	
	static {
		try {
			String resource = "mybatis/config1.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public List<EmpDTO> getList() {
		List<EmpDTO> list = sql.selectList("emp.listselect");
		return list;
	}//getList()

}//class
