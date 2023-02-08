package com.board.service.impl.board.like;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.board.entity.board.Board;
import com.board.entity.board.BoardRepository;
import com.board.entity.board.like.BoardLike;
import com.board.entity.board.like.BoardLikeRepository;
import com.board.entity.member.Member;
import com.board.entity.member.MemberRepository;
import com.board.service.board.like.BoardLikeService;

@Service
public class BoardLikeServiceImpl implements BoardLikeService {

	@Autowired
	BoardLikeRepository boardLikeRepository;
	
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	
	@Transactional
	@Override
	public Map<String, Object> save(long board_id, String account_id) throws NotFoundException {
		Board board = boardRepository.findById(board_id).orElseThrow(() -> new NotFoundException());
		Member member = memberRepository.findByAccountId(account_id);
		Map<String, Object> result = new HashMap<String, Object>();
		if(!isNotAlreadyLike(board, member)) {
			board.updateLikeCnt(board.getLikeCnt()+1);
			boardRepository.save(board);
        	boardLikeRepository.save(new BoardLike(board, member));
        	result.put("success", "좋아요 성공!");
        }else{
        	result.put("error", "이미 좋아요를 눌렀습니다.");
        }
		return result;
    }

	private boolean isNotAlreadyLike(Board board, Member member) {
		return boardLikeRepository.existsByBoardAndMember(board, member);
	}
 
}
