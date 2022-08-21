package com.oguzhanserttas.blog.service.impl;

import com.oguzhanserttas.blog.domain.Like;
import com.oguzhanserttas.blog.repository.LikeRepository;
import com.oguzhanserttas.blog.service.LikeService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Like}.
 */
@Service
@Transactional
public class LikeServiceImpl implements LikeService {

    private final Logger log = LoggerFactory.getLogger(LikeServiceImpl.class);

    private final LikeRepository likeRepository;

    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public Like save(Like like) {
        log.debug("Request to save Like : {}", like);
        return likeRepository.save(like);
    }

    @Override
    public Like update(Like like) {
        log.debug("Request to save Like : {}", like);
        return likeRepository.save(like);
    }

    @Override
    public Optional<Like> partialUpdate(Like like) {
        log.debug("Request to partially update Like : {}", like);

        return likeRepository
            .findById(like.getId())
            .map(existingLike -> {
                return existingLike;
            })
            .map(likeRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Like> findAll() {
        log.debug("Request to get all Likes");
        return likeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Like> findOne(Long id) {
        log.debug("Request to get Like : {}", id);
        return likeRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Like : {}", id);
        likeRepository.deleteById(id);
    }
}
