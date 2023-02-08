package com.board.service.impl.board;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dto.board.BoardDTO;
import com.board.entity.board.Board;
import com.board.entity.board.BoardRepository;
import com.board.service.board.BoardService;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardRepository boardRepository;
	
	@Override
	public List<Board> list(String account_type) {
		List<Board> list = boardRepository.findAll();
		return list;
	}

	@Override
	public void save(BoardDTO dto) {      
		Board params = Board.builder() 
						.accountId(dto.getAccountId())
						.title(dto.getTitle())
						.content(dto.getContent())
						.creatTime(LocalDateTime.now())
						.updateTime(null)
						.deleteTime(null)
						.build();
		boardRepository.save(params);
	}

	@Override
	public void update(long id, BoardDTO dto) {
		Board updateId = boardRepository.findById(id)
				.orElseThrow(()->new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
		updateId.update(dto.getTitle(), 
						dto.getContent(), 
						LocalDateTime.now());  
		
		boardRepository.save(updateId);
	}

	@Override
	public void delete(long id) {
		boardRepository.deleteById(id);
		
	}

}
