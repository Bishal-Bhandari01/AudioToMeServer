package com.audiotome.audiotomeserver.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;

<<<<<<< HEAD
    @RequestMapping(path = "/api/v1/comments",method = RequestMethod.POST)
    public CommentResponseDto SaveComments(@RequestBody CommentCreateDto requests){
        return commentService.saveComments(requests);
    }

    @RequestMapping(path = "/api/v1/getComments",method = RequestMethod.GET)
    public CommentListResponseDto GetComments(){
        return commentService.getComments();
    }

    @RequestMapping(path = "/api/v1/deletecomments",method = RequestMethod.DELETE)
=======
    @RequestMapping(path = "/api/v1/comments", method = RequestMethod.POST)
    public CommentResponseDto SaveComments(@RequestBody CommentCreateDto requests) {
        return commentService.saveComments(requests);
    }

    @RequestMapping(path = "/api/v1/getComments", method = RequestMethod.GET)
    public CommentListResponseDto GetComments() {
        return commentService.getComments();
    }

    @RequestMapping(path = "/api/v1/deletecomments", method = RequestMethod.DELETE)
>>>>>>> 17faaac ( new server hosting)
    public void DeleteComments(@RequestParam("id") Long id) throws Exception {
        commentService.deleteComments(id);
    }

<<<<<<< HEAD
    @RequestMapping(path = "/api/v1/deleteCommentsByuserid",method = RequestMethod.DELETE)
    public void DeleteCommentsByUserId(@RequestParam("userid") int id) throws Exception{
        commentService.deleteCommentsByUserID(id);
    }

    @RequestMapping(path="/api/v1/updateComments",method = RequestMethod.PUT)
    public CommentResponseDto UpdateComments(@RequestParam("id") Long id,@RequestBody CommentUpdateDto request){
        return commentService.updateComents(id,request);
    }

    @RequestMapping(path="/api/v1/updateLikes",method = RequestMethod.POST)
    public CommentResponseDto UpdateCommentsLike(@RequestParam("id") Long id,@RequestBody CommentUpdateDto request){
        return commentService.updateComentsLike(id,request);
=======
    @RequestMapping(path = "/api/v1/deleteCommentsByuserid", method = RequestMethod.DELETE)
    public void DeleteCommentsByUserId(@RequestParam("userid") int id) throws Exception {
        commentService.deleteCommentsByUserID(id);
    }

    @RequestMapping(path = "/api/v1/updateComments", method = RequestMethod.PUT)
    public CommentResponseDto UpdateComments(@RequestParam("id") Long id, @RequestBody CommentUpdateDto request) {
        return commentService.updateComents(id, request);
    }

    @RequestMapping(path = "/api/v1/updateLikes", method = RequestMethod.POST)
    public CommentResponseDto UpdateCommentsLike(@RequestParam("id") Long id, @RequestBody CommentUpdateDto request) {
        return commentService.updateComentsLike(id, request);
>>>>>>> 17faaac ( new server hosting)
    }
}
