package com.hoangtc.blog.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.hoangtc.blog.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ReactionTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Reaction.class);
        Reaction reaction1 = new Reaction();
        reaction1.setId(1L);
        Reaction reaction2 = new Reaction();
        reaction2.setId(reaction1.getId());
        assertThat(reaction1).isEqualTo(reaction2);
        reaction2.setId(2L);
        assertThat(reaction1).isNotEqualTo(reaction2);
        reaction1.setId(null);
        assertThat(reaction1).isNotEqualTo(reaction2);
    }
}
