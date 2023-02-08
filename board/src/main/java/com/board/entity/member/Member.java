package com.board.entity.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(length = 50)
	private String nickname; 
	
	@Column(length = 10)
	private String accountType; 
	
	@NotNull
	@Column(length = 50)
	private String accountId; 
	
	@Column(length = 2)
	private String quit; 
	

	@Builder
	public Member(String nickname, String accountType, String accountId, String quit) {
	    this.nickname = nickname;
	    this.accountType = accountType;
	    this.accountId = accountId;
	    this.quit = quit;
	}
}
