package com.audiotome.audiotomeserver.bookmarked;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class BookMarkController {

    @Autowired
    private BookMarkService bookMarkService;

    @RequestMapping(path = "/api/v1/addBookmark", method = RequestMethod.POST)
    public BookMarkResponseDto AddBookMark(@RequestBody BookMarkCreateDto req) {
        return bookMarkService.addBookMark(req);
    }

    @RequestMapping(path = "/api/v1/getBookMark", method = RequestMethod.GET)
    public BookMarkListResponseDto GetBookMark(@RequestParam("id") Long userid) {
        return bookMarkService.getBookMark(userid);
    }

    @RequestMapping(path = "/api/v1/removeBookmark", method = RequestMethod.DELETE)
    public void DeleteBookMark(@RequestParam("id") Long id) {
        bookMarkService.deleteBookmark(id);
    }

    @RequestMapping(path = "/api/v1/removeBookMarksByUserId", method = RequestMethod.DELETE)
    public void DeleteBookMarkByUserId(@RequestParam("id") int userId) {
        bookMarkService.deleteBookMarkByUserId(userId);
    }

}
