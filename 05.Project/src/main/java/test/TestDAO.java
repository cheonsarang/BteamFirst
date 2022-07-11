package test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestDAO {
	
	static SqlSession sql;
	
	static {
		try {
			String resource = "mybatis/config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sql = sqlSessionFactory.openSession(true);	//AutoCommit설정을 true
		} catch (IOException e) {
			e.printStackTrace();
		}//try
	}
	
	public void test() {
		int result = sql.selectOne("test.selectTest");
		System.out.println(result);
	}//test()
	
	
}//class
