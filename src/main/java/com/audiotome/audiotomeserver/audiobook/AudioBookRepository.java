package com.audiotome.audiotomeserver.audiobook;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AudioBookRepository extends CrudRepository<AudioBook, Long> {
    List<AudioBook> findByaBookNameContaining(String title);

    List<AudioBook> findByStatus(Status status);
}
