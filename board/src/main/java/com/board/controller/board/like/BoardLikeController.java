package com.board.controller.board.like;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.board.service.board.like.BoardLikeService;
import com.board.util.MemberEnum;

@RestController
public class BoardLikeController {

	@Autowired
	BoardLikeService boardLikeService;
	
	@PostMapping("/like/{id}")
	public Map<String, Object> like(@RequestHeader(value = "account_type", required = false) String account_type, @PathVariable long id) throws NotFoundException{
		Map<String, Object> result = new HashMap<String, Object>();
		String accountType = (String) MemberEnum.getAccountId(account_type).get("account_type");
		String accountId = (String) MemberEnum.getAccountId(account_type).get("id");
		if(accountType.equals("customer")) {
			result.put("error", "권한이 없습니다.");
			return result;
		}else {
			return boardLikeService.save(id, accountId);
		}
	}
	
}
