package com.mabotalb.nova_shop_api.product;

import com.mabotalb.nova_shop_api.category.CategoryDto;
import com.mabotalb.nova_shop_api.image.ImageDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Builder
public class ProductDto {

    private Long id;

    private String name;

    private String brand;

    private BigDecimal price;

    private int inventory;

    private String description;

    private CategoryDto category;

    private List<ImageDto> images;
}
