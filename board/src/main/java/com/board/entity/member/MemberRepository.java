package com.board.entity.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.dto.member.MemberDTO;

public interface MemberRepository extends JpaRepository<Member, Long>{

	Member findByAccountId(String findByAccountId);
} 
 