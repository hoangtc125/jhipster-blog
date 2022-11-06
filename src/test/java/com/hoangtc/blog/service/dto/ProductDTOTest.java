package com.hoangtc.blog.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.hoangtc.blog.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ProductDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ProductDTO.class);
        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setId(1L);
        ProductDTO productDTO2 = new ProductDTO();
        assertThat(productDTO1).isNotEqualTo(productDTO2);
        productDTO2.setId(productDTO1.getId());
        assertThat(productDTO1).isEqualTo(productDTO2);
        productDTO2.setId(2L);
        assertThat(productDTO1).isNotEqualTo(productDTO2);
        productDTO1.setId(null);
        assertThat(productDTO1).isNotEqualTo(productDTO2);
    }
}
