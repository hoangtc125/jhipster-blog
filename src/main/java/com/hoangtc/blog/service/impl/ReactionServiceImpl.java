package com.hoangtc.blog.service.impl;

import com.hoangtc.blog.domain.Reaction;
import com.hoangtc.blog.repository.ReactionRepository;
import com.hoangtc.blog.service.ReactionService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Reaction}.
 */
@Service
@Transactional
public class ReactionServiceImpl implements ReactionService {

    private final Logger log = LoggerFactory.getLogger(ReactionServiceImpl.class);

    private final ReactionRepository reactionRepository;

    public ReactionServiceImpl(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }

    @Override
    public Reaction save(Reaction reaction) {
        log.debug("Request to save Reaction : {}", reaction);
        return reactionRepository.save(reaction);
    }

    @Override
    public Reaction update(Reaction reaction) {
        log.debug("Request to update Reaction : {}", reaction);
        return reactionRepository.save(reaction);
    }

    @Override
    public Optional<Reaction> partialUpdate(Reaction reaction) {
        log.debug("Request to partially update Reaction : {}", reaction);

        return reactionRepository
            .findById(reaction.getId())
            .map(existingReaction -> {
                if (reaction.getEmotion() != null) {
                    existingReaction.setEmotion(reaction.getEmotion());
                }

                return existingReaction;
            })
            .map(reactionRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Reaction> findAll(Pageable pageable) {
        log.debug("Request to get all Reactions");
        return reactionRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Reaction> findOne(Long id) {
        log.debug("Request to get Reaction : {}", id);
        return reactionRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Reaction : {}", id);
        reactionRepository.deleteById(id);
    }
}
