package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO implements BoardService {
	@Autowired @Qualifier("bteam") private SqlSession sql;

	@Override
	public int board_insert(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> board_list() {
		
		return sql.selectList("board.board_list");
	}

	@Override
	public BoardVO board_detail(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int board_read(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int board_update(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int board_delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}



}
