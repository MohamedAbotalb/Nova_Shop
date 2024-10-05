package com.mabotalb.nova_shop_api.category;

import com.mabotalb.nova_shop_api.common.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends GenericMapper<Category, CategoryDto> {
}
