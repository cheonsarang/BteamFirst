package school;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SchoolpostlDAO {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	//CRUD(Create, Read, Upload, Delete)
	
	//리스트
	public List<SchoolpostVO> schoolpost_list(){
		return sql.selectList("school.list");
	}
	
	//작성
	public int schoolpost_insert(SchoolpostVO vo) {
		return sql.insert("school.insert", vo);
	}
	
	//상세페이지
	public SchoolpostVO schoolpost_detail(int id) {
		return sql.selectOne("school.detail", id);
	}
	
	//수정
	public int schoolpost_update(SchoolpostVO vo) {
		int dml = sql.update("school.update", vo);
		return dml;
	}
	
	//삭제
	public int schoolpost_delete(int id) {
		return sql.delete("school.delete", id);
	}

}
