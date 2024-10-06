package com.mabotalb.nova_shop_api.category;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAllCategories();

    CategoryDto getCategoryById(Long id);

    CategoryDto getCategoryByName(String name);

    CategoryDto addCategory(CategoryRequest request);

    CategoryDto updateCategory(CategoryRequest request, Long id);

    void deleteCategoryById(Long id);
}
