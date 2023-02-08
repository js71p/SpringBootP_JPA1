package com.board.controller.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.board.dto.board.BoardDTO;
import com.board.entity.board.Board;
import com.board.service.board.BoardService;
import com.board.util.MemberEnum;

@RestController
public class BoardController {
	
	@Autowired 
	BoardService boardService;
	
	@GetMapping("/board")
	public Map<String, Object> BoardList(@RequestHeader(value = "account_type", required = false) String account_type) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Board> list = boardService.list(account_type);
		result.put("Authentication", MemberEnum.getAccountId(account_type));
		result.put("list", list);
		return result;
	}
	
	@PostMapping("/board")
	public Map<String, Object> BoardSave(@RequestHeader(value = "account_type", required = false) String account_type,@RequestBody BoardDTO dto) {
		Map<String, Object> result = new HashMap<String, Object>();
		String accountType = (String) MemberEnum.getAccountId(account_type).get("account_type");
		String accountId = (String) MemberEnum.getAccountId(account_type).get("id");
		if(accountType.equals("customer")) {
			result.put("error", "게시글 권한이 없습니다.");
		}else {
			dto.setAccountId(accountId);
			dto.setContent(dto.getContent());
			boardService.save(dto);
			result.put("success", "완료!"); 
		}
		return result;
	}
	
	@PutMapping("/board/{id}")
	public Map<String, Object> BoardUpdate(@RequestHeader(value = "account_type", required = false) String account_type, @RequestBody BoardDTO dto, @PathVariable long id){
		Map<String, Object> result = new HashMap<String, Object>();
		String accountType = (String) MemberEnum.getAccountId(account_type).get("account_type");
		String accountId = (String) MemberEnum.getAccountId(account_type).get("id");
		if(accountType.equals("customer")) {
			result.put("error", "게시글 권한이 없습니다.");
		}else {
			
			boardService.update(id, dto);
			result.put("success", "완료!"); 
		}
		return result;
		}
	
	@DeleteMapping("/board/{id}")
	public Map<String, Object> BoardDelete(@RequestHeader(value = "account_type", required = false) String account_type, @RequestBody BoardDTO dto, @PathVariable long id){
		Map<String, Object> result = new HashMap<String, Object>();
		String accountType = (String) MemberEnum.getAccountId(account_type).get("account_type");
		String accountId = (String) MemberEnum.getAccountId(account_type).get("id");
		if(accountType.equals("customer")) {
			result.put("error", "게시글 권한이 없습니다.");
		}else {
			boardService.delete(id);
			result.put("success", "완료!"); 
		}
		return result;
	}
}
