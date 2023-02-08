package com.board.board;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.board.entity.board.Board;
import com.board.entity.board.BoardRepository;

@SpringBootTest
public class BoardTest {
	
	@Autowired
	BoardRepository boardRepository;

    @Test
    void save() {

        Board params = Board.builder()
        		.accountId("lessee")
        		.title("타이틀")
        		.content("제목")
        		.creatTime(LocalDateTime.now())
        		.build();

        boardRepository.save(params);
    }
    @Test
    void update() {
    	Board params = Board.builder()
    			.accountId("lessee")
    			.title("타이틀")
    			.content("우라라라ㅏ라")
    			.updateTime(LocalDateTime.now())
    			.build();
    	
    	 boardRepository.save(params);
    }
    
    

    @Test
    void findAll() {

        long boardsCount = boardRepository.count();
        List<Board> boards = boardRepository.findAll();
    }

    @Test
    void delete() {

        Board entity = boardRepository.findById((long) 1).get();
        boardRepository.delete(entity);
    }
}
