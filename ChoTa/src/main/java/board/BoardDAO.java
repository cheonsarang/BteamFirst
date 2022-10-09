package board;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements BoardService {
	@Autowired @Qualifier("bteam") private SqlSession sql;

	@Override
	public int board_insert(BoardVO insertvo) {
	
	//return sql.insert("board.insert", insertvo);
	//방명록 글을 저장한 후
			int dml = sql.insert("board.insert", insertvo);
			//첨부파일이 있는 경우 첨부파일 정보로 저장한다
			if( insertvo.getFileInfo() != null) sql.insert("board.file_insert", insertvo);	
			return dml;

	}


	@Override	//(글 상세보기 연결된 파일정보까지)
	public BoardVO board_detail(int id) {
		BoardVO vo = sql.selectOne("board.detail", id);
		vo.setFileInfo(sql.selectList("board.file_list", id));
		
		return vo;
	}

	@Override
	public int board_read(int id) {
		
		return sql.update("board.read", id);
	}

	@Override	//(글 수정하기 연결괸 파일정보까지)
	public int board_update(BoardVO vo) {
		int dml = sql.update("board.update", vo);
		if( vo.getFileInfo() !=null) sql.insert("board.file_insert", vo);
		
		return dml;
	}

	@Override	//글 삭제처리
	public int board_delete(int id) {
		
		return sql.delete("board.delete", id);
	}


	@Override	//(게시판그룹별 게시판 목록 조회)
	public List<BoardVO> board_list(String board_group_id) {
		
		
		return sql.selectList("board.board_list_grp", board_group_id);
	}

	@Override 	//(게시판 순위별 글 목록 조회)
	public List<BoardVO> board_rank() {
		
		return sql.selectList("board.board_rank");
	}

	@Override	//(게시판 총글 목록 조회)
	public List<BoardVO> board_list() {
		
		return sql.selectList("board.board_list");
	}


	@Override	//게시판 첨부파일 다운로드할때 쓰일 정보조회
	public BoardFileVO board_file_info(int id) {
		
		return sql.selectOne("board.file_info", id);
	}


	@Override	//첨부파일 목록 조회
	public List<BoardFileVO> board_file_list(String removed) {
		
		return sql.selectList("board.file_list_in", removed);
	}


	@Override	//방명록 글 삭제시 첨부파일 목록 조회
	public List<BoardFileVO> board_file_list(int board_id) {
		
		return sql.selectList("board.file_list", board_id);
	}


	@Override	//삭제대상 첨부파일정보 삭제
	public int board_file_delete(String removed) {
		
		return sql.delete("board.file_delete", removed);
	}

////////////////////////////////////////////////////////////////////////////////

	@Override	//댓글 신규저장
	public int board_comment_insert(BoardCommentVO vo) {
		
		return sql.insert("board.comment_insert", vo);
	}


	@Override	//댓글 리스트
	public List<BoardCommentVO> board_comment_list(int board_id) {
		
		return sql.selectList("board.comment_list", board_id);
	}


	@Override	//댓글 수정
	public int board_comment_update(BoardCommentVO vo) {
		
		return sql.update("board.comment_update", vo);
	}


	@Override	//댓글 삭제
	public int board_comment_delete(int id) {

		return sql.delete("board.comment_delete", id);
	}


	@Override
	public int scrap_insert(BoardVO vo) {
		
		return sql.insert("board.scrap_insert", vo);
	}


	@Override
	public int scrap_delete(BoardVO vo) {
		
		return sql.delete("board.scrap_delete", vo);
	}








}
