package com.audiotome.audiotomeserver.Notes;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

<<<<<<< HEAD
public interface NoteRepository extends CrudRepository<Notes,Long> {
=======
public interface NoteRepository extends CrudRepository<Notes, Long> {
>>>>>>> 17faaac ( new server hosting)
    List<Notes> findByUserId(Long user_id);
}
