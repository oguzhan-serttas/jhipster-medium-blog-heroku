package com.oguzhanserttas.blog.service.impl;

import com.oguzhanserttas.blog.domain.Post;
import com.oguzhanserttas.blog.repository.PostRepository;
import com.oguzhanserttas.blog.service.PostService;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Post}.
 */
@Service
@Transactional
public class PostServiceImpl implements PostService {

    private final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post save(Post post) {
        log.debug("Request to save Post : {}", post);
        post.setCreatedAt(Instant.now());
        return postRepository.save(post);
    }

    @Override
    public Post update(Post post) {
        log.debug("Request to save Post : {}", post);
        post.setUpdatedAt(Instant.now());
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> partialUpdate(Post post) {
        log.debug("Request to partially update Post : {}", post);
        post.setUpdatedAt(Instant.now());
        return postRepository
            .findById(post.getId())
            .map(existingPost -> {
                if (post.getContent() != null) {
                    existingPost.setContent(post.getContent());
                }
                if (post.getTitle() != null) {
                    existingPost.setTitle(post.getTitle());
                }
                if (post.getCreatedAt() != null) {
                    existingPost.setCreatedAt(post.getCreatedAt());
                }
                if (post.getUpdatedAt() != null) {
                    existingPost.setUpdatedAt(post.getUpdatedAt());
                }

                return existingPost;
            })
            .map(postRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> findAll() {
        log.debug("Request to get all Posts");
        return postRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Post> findOne(Long id) {
        log.debug("Request to get Post : {}", id);
        return postRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Post : {}", id);
        postRepository.deleteById(id);
    }
}
