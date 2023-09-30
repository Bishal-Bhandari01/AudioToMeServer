package com.audiotome.audiotomeserver.audiobook;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

<<<<<<< HEAD
public interface AudioBookRepository extends CrudRepository<AudioBook,Long> {
=======
public interface AudioBookRepository extends CrudRepository<AudioBook, Long> {
>>>>>>> 17faaac ( new server hosting)
    List<AudioBook> findByaBookNameContaining(String title);

    List<AudioBook> findByStatus(Status status);
}
