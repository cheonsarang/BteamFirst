package chotamember;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScheduleDAO {
	@Autowired private SqlSession sql;

	public List<ScheduleVO> schedule_list(ScheduleVO vo) {
		return sql.selectList("data.schedule_list", vo);
	}

	public int schedule_update(ScheduleVO vo) {
		return sql.update("data.schedule_update", vo);
	}

	public List<ScheduleVO> schedule_all(ScheduleVO vo) {
		return sql.selectList("data.schedule_all", vo);
	}

	public void schedule_insert(ScheduleVO vo) {
		sql.insert("data.schedule_insert", vo);
	}

	public void schedule_delete(ScheduleVO vo) {
		sql.delete("data.schedule_delete", vo);
	}
	
	
	
}
