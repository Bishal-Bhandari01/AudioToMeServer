package com.audiotome.audiotomeserver.bookmarked;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookMarkService {

    @Autowired
    private BookMarkRepository bMarkRepo;

    public BookMarkResponseDto addBookMark(BookMarkCreateDto req) {
        BookMark bookMarkReq = new BookMark();
        bookMarkReq.setAudioBookId(req.getAudioBookId());
        bookMarkReq.setUserId(req.getUserId());
        BookMark savedBookmark = bMarkRepo.save(bookMarkReq);
        return getBookMarkResponse(savedBookmark);
    }

    private BookMarkResponseDto getBookMarkResponse(BookMark savedBookmark) {
        BookMarkResponseDto responseDto = new BookMarkResponseDto();
        responseDto.setB_id(savedBookmark.b_id);
        responseDto.setUserId(savedBookmark.getUserId());
        responseDto.setAudioBookId(savedBookmark.getAudioBookId());
        return responseDto;
    }

    public BookMarkListResponseDto getBookMark(Long userid) {
        List<BookMarkResponseDto> responseDtoList = new ArrayList<>();
        List<BookMark> bookMarks = bMarkRepo.findByUserId(userid);
<<<<<<< HEAD
        for(BookMark bookMark: bookMarks){
=======
        for (BookMark bookMark : bookMarks) {
>>>>>>> 17faaac ( new server hosting)
            responseDtoList.add(getBookMarkResponse(bookMark));
        }
        BookMarkListResponseDto listResponseDto = new BookMarkListResponseDto();
        listResponseDto.setResponseDtoList(responseDtoList);
        listResponseDto.setTotal(responseDtoList.size());
        return listResponseDto;
    }
<<<<<<< HEAD
=======

>>>>>>> 17faaac ( new server hosting)
    @Transactional
    public void deleteBookmark(Long id) {
        bMarkRepo.deleteById(id);
    }

    @Transactional
<<<<<<< HEAD
    public void deleteBookMarkByUserId(int id){
=======
    public void deleteBookMarkByUserId(int id) {
>>>>>>> 17faaac ( new server hosting)
        bMarkRepo.deleteByUserId(id);
    }
}
