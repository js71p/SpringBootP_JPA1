package com.board.dto.board;

import java.time.LocalDateTime;

import com.board.entity.board.Board;

import lombok.Data;

@Data
public class BoardDTO {

//	- 글에 `좋아요`는 한 계정이 한 글에 한 번만 할 수 있습니다.
//	- 어떤 사용자가 어떤 글에 좋아요 했는지 히스토리를 확인할 수 있어야 합니다.
//	- 각 글은 작성시간, 마지막 수정시간, 삭제시간에 대한 히스토리를 확인할 수 있어야 합니다

	private Long id; 
	private String accountId; 
	private String content;
	private String title;
	private LocalDateTime creatTime;
	private LocalDateTime updateTime;
	private LocalDateTime deleteTime;
	private Long cnt; 
	private Long likeCnt; 
	
}
