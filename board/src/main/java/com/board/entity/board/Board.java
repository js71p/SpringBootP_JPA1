package com.board.entity.board;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.board.dto.board.BoardDTO;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@DynamicInsert
@DynamicUpdate
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50, nullable = false)
	private String accountId;
	
	@Column(length = 100)
	private String title;
	
	@Column(length = 2000)
	private String content;

	private LocalDateTime creatTime;
	private LocalDateTime updateTime;
	private LocalDateTime deleteTime;

	@ColumnDefault("0")
	private Long cnt;

	@ColumnDefault("0")
    private Long likeCnt;
	
	@Builder
	public Board (Long id, String accountId, String title, String content, LocalDateTime creatTime, LocalDateTime updateTime, LocalDateTime deleteTime,
			Long cnt, Long likeCnt) {
		this.id = id;
		this.title = title;
		this.accountId = accountId;
		this.content = content;
		this.creatTime = creatTime;
		this.updateTime = updateTime;
		this.deleteTime = deleteTime;
		this.cnt = cnt;
		this.likeCnt = likeCnt;
	}
	
	public void update(String title, String content, LocalDateTime updateTime) {
        this.title = title;
        this.content = content;
        this.updateTime = updateTime;
    }
	
	public void updateLikeCnt(long likeCnt) {
		this.likeCnt = likeCnt;
	}

}
