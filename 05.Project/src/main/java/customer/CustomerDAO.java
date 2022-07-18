package customer;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import customer.customerDTO;

public class customerDAO {
	static SqlSession sql;
	static {
		String resource = "mybatis/config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession(true); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<customerDTO> getList(){
		// sql.update , sql.delete , sql.selectone , seclectlist (return타입이 List)
		List<customerDTO> list = sql.selectList("cus.listselect");
		return list;
	}
	
	public int delete(String id) {
		return sql.delete("cus.delete", id);
		
	}
	
	
	
}
