package com.board.entity.board.like;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.entity.board.Board;
import com.board.entity.member.Member;

public interface BoardLikeRepository extends JpaRepository<BoardLike, Long> {

	boolean existsByBoardAndMember(Board board,Member member);
	
}
