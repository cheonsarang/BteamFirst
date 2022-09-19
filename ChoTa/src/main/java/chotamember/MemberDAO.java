package chotamember;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	public List<MemberVO> chota_list() {
		return sql.selectList("chota.list");
	}

	public MemberVO login(HashMap<String, String> map) {
		
		return sql.selectOne("chota.login", map);
	}
	
}

