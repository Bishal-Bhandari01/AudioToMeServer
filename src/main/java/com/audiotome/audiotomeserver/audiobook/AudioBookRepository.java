package com.audiotome.audiotomeserver.audiobook;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;

public interface AudioBookRepository extends CrudRepository<AudioBook, Long> {
    List<AudioBook> findByaBookNameContaining(String title);

    List<AudioBook> findByStatus(Status status);

    List<AudioBook> findByaUploadDate(LocalDate time);

    List<AudioBook> findByaUploadDateBetween(LocalDate startDate, LocalDate endDate);

    List<AudioBook> findTop5ByOrderByListenDesc();
}
