package com.audiotome.audiotomeserver.Notes;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface NoteRepository extends CrudRepository<Notes, Long> {
    List<Notes> findByUserId(Long user_id);
}
