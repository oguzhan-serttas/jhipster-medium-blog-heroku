package com.oguzhanserttas.blog.service;

import com.oguzhanserttas.blog.domain.Like;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Like}.
 */
public interface LikeService {
    /**
     * Save a like.
     *
     * @param like the entity to save.
     * @return the persisted entity.
     */
    Like save(Like like);

    /**
     * Updates a like.
     *
     * @param like the entity to update.
     * @return the persisted entity.
     */
    Like update(Like like);

    /**
     * Partially updates a like.
     *
     * @param like the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Like> partialUpdate(Like like);

    /**
     * Get all the likes.
     *
     * @return the list of entities.
     */
    List<Like> findAll();

    /**
     * Get the "id" like.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Like> findOne(Long id);

    /**
     * Delete the "id" like.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
