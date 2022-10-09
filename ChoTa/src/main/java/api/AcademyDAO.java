package api;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AcademyDAO {
	@Autowired private SqlSession sql;

	public void data_insert(AcademyVO vo) {
		sql.insert("data.insert", vo);
	}

	public void data_delete(AcademyVO vo) {
		sql.delete("data.delete", vo);
	}

	public List<AcademyVO> heart_list(String userid) {
		return sql.selectList("data.heart_list", userid);
	}
	
	//찜
	

}
