package com.hoangtc.blog.service;

import com.hoangtc.blog.domain.Blog;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Blog}.
 */
public interface BlogService {
    /**
     * Save a blog.
     *
     * @param blog the entity to save.
     * @return the persisted entity.
     */
    Blog save(Blog blog);

    /**
     * Updates a blog.
     *
     * @param blog the entity to update.
     * @return the persisted entity.
     */
    Blog update(Blog blog);

    /**
     * Partially updates a blog.
     *
     * @param blog the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Blog> partialUpdate(Blog blog);

    /**
     * Get all the blogs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Blog> findAll(Pageable pageable);

    /**
     * Get the "id" blog.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Blog> findOne(Long id);

    /**
     * Delete the "id" blog.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
