package customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerDAO {
	
	private static SqlSession sql;
	
	static {
		try {
			String resource = "mybatis/config.xml";
			InputStream inputStream;
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}//try
	}//static
	
	public List<CustomerDTO> getList(){
		
		List<CustomerDTO> list = sql.selectList("cus.listselect"); 	
		return list;
	}//list()
	
	public int delete(CustomerDTO dto) {
		int result = sql.delete("cus.deletedata",dto);
		System.out.println(result);
		return result;
	}
	
	public int delete(String id) {
		return sql.delete("cus.deletedata", id);
	}
}//class
