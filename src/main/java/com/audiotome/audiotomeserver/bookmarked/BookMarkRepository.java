package com.audiotome.audiotomeserver.bookmarked;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookMarkRepository extends CrudRepository<BookMark, Long> {
    List<BookMark> findByUserId(Long userid);

    void deleteByUserId(int id);
}
