package com.audiotome.audiotomeserver.comments;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepo;

    public CommentResponseDto saveComments(CommentCreateDto requests) {
        Comments comments = new Comments();
        comments.setCommentContent(requests.getCommentContent());
        comments.setUserId(requests.getUserId());
        comments.setA_id(requests.getA_id());
        comments.setC_likes(requests.getC_likes());
        Comments savedComment = commentRepo.save(comments);
        return getCommentsResponseDto(savedComment);
    }

    private CommentResponseDto getCommentsResponseDto(Comments savedComment) {
        CommentResponseDto comments = new CommentResponseDto();
        comments.setC_id(savedComment.getC_id());
        comments.setCommentContent(savedComment.getCommentContent());
        comments.setUserId(savedComment.getUserId());
        comments.setA_id(savedComment.getA_id());
        comments.setC_likes(savedComment.getC_likes());
        return comments;
    }

    public CommentListResponseDto getComments() {
        List<CommentResponseDto> response = new ArrayList<>();
        List<Comments> comm = (List<Comments>) commentRepo.findAll();
<<<<<<< HEAD
        for(Comments comment: comm){
=======
        for (Comments comment : comm) {
>>>>>>> 17faaac ( new server hosting)
            response.add(getCommentsResponseDto(comment));
        }
        CommentListResponseDto responseDto = new CommentListResponseDto();
        responseDto.setResponseDtoList(response);
        responseDto.setTotal(response.size());
        return responseDto;
    }
<<<<<<< HEAD
=======

>>>>>>> 17faaac ( new server hosting)
    @Transactional
    public void deleteComments(Long id) throws Exception {
        commentRepo.deleteById(id);
    }

    @Transactional
    public void deleteCommentsByUserID(int id) throws Exception {
        commentRepo.deleteByUserId(id);
    }

    public CommentResponseDto updateComents(Long id, CommentUpdateDto request) {
        Optional<Comments> comments = commentRepo.findById(id);
<<<<<<< HEAD
        if(comments.isPresent()){
=======
        if (comments.isPresent()) {
>>>>>>> 17faaac ( new server hosting)
            Comments comm = comments.get();
            comm.setCommentContent(request.getCommentContent());
            Comments savedComm = commentRepo.save(comm);
            return getCommentsResponseDto(savedComm);
        }
        return null;
    }

    public CommentResponseDto updateComentsLike(Long id, CommentUpdateDto request) {
        Optional<Comments> comments = commentRepo.findById(id);
<<<<<<< HEAD
        if(comments.isPresent()){
=======
        if (comments.isPresent()) {
>>>>>>> 17faaac ( new server hosting)
            Comments comm = comments.get();
            comm.setC_likes(request.getC_likes());
            Comments savedComm = commentRepo.save(comm);
            return getCommentsResponseDto(savedComm);
        }
        return null;
    }
}
