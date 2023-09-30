package com.audiotome.audiotomeserver.comments;

import org.springframework.data.repository.CrudRepository;

<<<<<<< HEAD
public interface CommentRepository extends CrudRepository<Comments,Long> {
=======
public interface CommentRepository extends CrudRepository<Comments, Long> {
>>>>>>> 17faaac ( new server hosting)

    void deleteByUserId(int id);
}
