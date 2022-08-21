package com.oguzhanserttas.blog.service;

import com.oguzhanserttas.blog.domain.Role;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Role}.
 */
public interface RoleService {
    /**
     * Save a role.
     *
     * @param role the entity to save.
     * @return the persisted entity.
     */
    Role save(Role role);

    /**
     * Updates a role.
     *
     * @param role the entity to update.
     * @return the persisted entity.
     */
    Role update(Role role);

    /**
     * Partially updates a role.
     *
     * @param role the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Role> partialUpdate(Role role);

    /**
     * Get all the roles.
     *
     * @return the list of entities.
     */
    List<Role> findAll();

    /**
     * Get the "id" role.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Role> findOne(Long id);

    /**
     * Delete the "id" role.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
