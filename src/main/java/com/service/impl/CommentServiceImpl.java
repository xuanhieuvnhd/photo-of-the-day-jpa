package com.service.impl;

import com.model.Comment;
import com.repository.CommentRepository;
import com.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    public static final String GET_ALL_COMMENT = "select c from Comment c where current_date = c.createAt";
    @Autowired
    private CommentRepository commentRepository;
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> getAllCommentByDate() {
        TypedQuery<Comment> query = em.createQuery(GET_ALL_COMMENT, Comment.class);
        return query.getResultList();
    }

    @Override
    public void incrementLike(Comment comment) {
        em.merge(comment);
    }

    @Override
    public Comment getById(Long id) {
        return commentRepository.getReferenceById(id);
    }

    @Override
    public void insertComment(Comment comment) {
        commentRepository.save(comment);
    }
}
