package com.audiotome.audiotomeserver.comments;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comments, Long> {

    void deleteByUserId(int id);
}
