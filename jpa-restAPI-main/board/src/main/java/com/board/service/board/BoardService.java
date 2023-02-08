package com.board.service.board;

import java.util.List;

import com.board.dto.board.BoardDTO;
import com.board.entity.board.Board;

public interface BoardService {
	
	List<Board> list(String account_type);
	
	void save(BoardDTO dto); 
	
	void update(long id, BoardDTO dto);
	
	void delete(long id);
}
