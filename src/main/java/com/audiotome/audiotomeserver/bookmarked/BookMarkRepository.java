package com.audiotome.audiotomeserver.bookmarked;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

<<<<<<< HEAD
public interface BookMarkRepository extends CrudRepository<BookMark,Long> {
=======
public interface BookMarkRepository extends CrudRepository<BookMark, Long> {
>>>>>>> 17faaac ( new server hosting)
    List<BookMark> findByUserId(Long userid);

    void deleteByUserId(int id);
}
