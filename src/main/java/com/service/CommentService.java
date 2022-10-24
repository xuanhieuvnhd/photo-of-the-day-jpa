package com.service;

import com.model.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllCommentByDate();
    void incrementLike(Comment comment);
    Comment getById(Long id);
    void insertComment(Comment comment);
}
