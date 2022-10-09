package chotamember;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import chotamember.MemberVO;

@Repository
public class MemberDAO {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	public int profile_update(MemberVO mvo) {
		return sql.update("chota.profile_update", mvo);
	}
	
	//이벤트 참여
		public int event_check(EventVO vo) {
			return sql.update("chota.event_check", vo);
		}
		
		//이벤트 처음 참여
		public int eventinsert(String userid) {
			return sql.insert("chota.eventinsert", userid);
		}
		
		//이밴트 조회
		public List<EventVO> eventlist(String userid) {
			return sql.selectList("chota.eventlist", userid);
		}
	
	//멤버목록
	public List<MemberVO> chota_list() {
		return sql.selectList("chota.list");
	}

	//로그인
	public MemberVO login(HashMap<String, String> map, String social) {
		if( social.equals("Y") ) {
			return sql.selectOne("chota.social", map);
		}else {
			return sql.selectOne("chota.login", map);
		}	
	}

	//선생님의 반학생 목록
	public List<MemberVO> ban_list(String name) {
		return sql.selectList("chota.banlist", name);
	}

	//멤버 상세보기
	public MemberVO member_detail(String id) {
		return sql.selectOne("chota.detail", id);
	}

	//회원가입
	public int member_join(MemberVO joinInfo) {
		
		return sql.insert("chota.join", joinInfo);
	}
	
	//아이디 중복체크
	public int member_id_check(String userid) {
		//존재하는 경우 : 1(true), 아니면 0(false)
		return sql.selectOne("chota.id_check", userid);
	}
	
	//아이디 찾기
	public MemberVO member_id_find(MemberVO findId) {
		//존재하는 경우 : 1(true), 아니면 0(false)
		return sql.selectOne("chota.id_find", findId);
	}

	//비밀번호 찾기지만 폰번호로 정보확인
	public int member_pw_find1(String phone) {
		//존재하는 경우 : 1(true), 아니면 0(false)
		return sql.selectOne("chota.pw_find1",phone);
		
	}
	
	//전 비밀번호 중복체크
	public int member_pw_check(HashMap<String, String> map) {
		//존재하는 경우 : 1(true), 아니면 0(false)
		return sql.selectOne("chota.pw_check", map);
	}
	
	//비밀번호 찾기지만 비밀번호 재설정
	public int member_pw_find2(HashMap<String, String> map) {
		//정보 재설정 완료 : 1(true), 0(false)
		return sql.update("chota.pw_find2", map);
	}

	//학교검색해서 학교번호담기
	public String member_school_chk(String school_name) {
		
		
		return sql.selectOne("chota.school_chk", school_name);
		
	}


//////////////////////////////////////////////////////////////////////////////웹에서 필요한 메소드	
	//내정보 수정
	public int member_update(MemberVO vo) {
		
		return sql.update("chota.update", vo);
	}
	
	
	
	
	
}
