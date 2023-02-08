package com.board.entity.board.like;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.board.entity.board.Board;
import com.board.entity.member.Member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate 
@Entity
public class BoardLike {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "accountId")
    private Member member;
	
	
	@Builder
	public BoardLike (Board board, Member member) {
		this.board = board;
		this.member = member;
	} 
}
