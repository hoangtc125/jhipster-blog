package com.hoangtc.blog.service;

import com.hoangtc.blog.domain.Reaction;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Reaction}.
 */
public interface ReactionService {
    /**
     * Save a reaction.
     *
     * @param reaction the entity to save.
     * @return the persisted entity.
     */
    Reaction save(Reaction reaction);

    /**
     * Updates a reaction.
     *
     * @param reaction the entity to update.
     * @return the persisted entity.
     */
    Reaction update(Reaction reaction);

    /**
     * Partially updates a reaction.
     *
     * @param reaction the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Reaction> partialUpdate(Reaction reaction);

    /**
     * Get all the reactions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Reaction> findAll(Pageable pageable);

    /**
     * Get the "id" reaction.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Reaction> findOne(Long id);

    /**
     * Delete the "id" reaction.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
