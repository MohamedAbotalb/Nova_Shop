package com.mabotalb.nova_shop_api.category;

import com.mabotalb.nova_shop_api.exception.AlreadyExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = this.categoryRepository.findAll();
        return this.categoryMapper.toDtos(categories);
    }

    private Category getCategory(Long id) {
        return this.categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
    }

    public Category getCategory(String name) {
        Category category = this.categoryRepository.findByName(name);
        if (category == null) {
            throw new EntityNotFoundException("Category not found with name: " + name);
        }
        return category;
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = this.getCategory(id);
        return this.categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto getCategoryByName(String name) {
        Category category = this.getCategory(name);
        return this.categoryMapper.toDto(category);
    }

    @Override
    @Transactional
    public CategoryDto addCategory(@NotNull CategoryRequest request) {
        // Check if the category is already exist
        Category category = this.categoryRepository.findByName(request.getName());
        if (category != null) {
            throw new AlreadyExistsException("Category already exists with name: " + request.getName());
        }

        Category newCategory = Category.builder()
               .name(request.getName())
               .build();
        this.categoryRepository.save(newCategory);
        return this.categoryMapper.toDto(newCategory);
    }

    @Override
    @Transactional
    public CategoryDto updateCategory(@NotNull CategoryRequest request, Long id) {
        // Check if the category is not exiting
        Category category = this.getCategory(id);

        // Update the category
        category.setName(request.getName());
        this.categoryRepository.save(category);
        return this.categoryMapper.toDto(category);
    }

    @Override
    @Transactional
    public void deleteCategoryById(Long id) {
        Category category = this.getCategory(id);
        this.categoryRepository.delete(category);
    }
}
