package com.hoangtc.blog.service.mapper;

import com.hoangtc.blog.domain.Product;
import com.hoangtc.blog.service.dto.ProductDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {}
