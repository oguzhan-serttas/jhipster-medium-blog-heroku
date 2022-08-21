package com.oguzhanserttas.blog.service.impl;

import com.oguzhanserttas.blog.domain.Comment;
import com.oguzhanserttas.blog.repository.CommentRepository;
import com.oguzhanserttas.blog.service.CommentService;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Comment}.
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment save(Comment comment) {
        log.debug("Request to save Comment : {}", comment);
        comment.setCreatedAt(Instant.now());
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        log.debug("Request to save Comment : {}", comment);
        comment.setUpdatedAt(Instant.now());
        return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> partialUpdate(Comment comment) {
        log.debug("Request to partially update Comment : {}", comment);
        comment.setUpdatedAt(Instant.now());
        return commentRepository
            .findById(comment.getId())
            .map(existingComment -> {
                if (comment.getComment() != null) {
                    existingComment.setComment(comment.getComment());
                }
                if (comment.getCreatedAt() != null) {
                    existingComment.setCreatedAt(comment.getCreatedAt());
                }
                if (comment.getUpdatedAt() != null) {
                    existingComment.setUpdatedAt(comment.getUpdatedAt());
                }

                return existingComment;
            })
            .map(commentRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comment> findAll() {
        log.debug("Request to get all Comments");
        return commentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Comment> findOne(Long id) {
        log.debug("Request to get Comment : {}", id);
        return commentRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Comment : {}", id);
        commentRepository.deleteById(id);
    }
}
