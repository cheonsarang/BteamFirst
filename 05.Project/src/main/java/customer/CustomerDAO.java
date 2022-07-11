package customer;

<<<<<<< HEAD
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
=======
import java.util.List;

import common.CommonDAO;

public class CustomerDAO extends CommonDAO{

	CustomerDTO dto = new CustomerDTO();
//	static SqlSession sql;	//CommonDAO를 상속받아서 필요없다
//	static {
//
//		try {
//			String resource = "mybatis/config.xml";
//			InputStream inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			sql = sqlSessionFactory.openSession(true);	//AutoCommit설정을 true
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	public List<CustomerDTO> getList(){
		List<CustomerDTO> list = sql.selectList("cus.list");

		return list;
		
	}

	public int delete(String id) {
		
	return sql.delete("cus.delete", id);
	
	}
}
>>>>>>> d9f14bf55e061a43cdbfa2b9837d14f2f5b3fb2f
