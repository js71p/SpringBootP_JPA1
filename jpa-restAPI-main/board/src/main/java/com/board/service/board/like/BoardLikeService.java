package com.board.service.board.like;

import java.util.Map;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface BoardLikeService {

	Map<String, Object> save(long id, String account_id) throws NotFoundException;
}
