package com.board.dto.member;

import lombok.Data;

@Data
public class MemberDTO {
	
	private Long id; 
	private String nickname; 
	private String accountType; 
	private String accountId; 
	private String quit; 
}
