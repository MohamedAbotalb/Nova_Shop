package com.mabotalb.nova_shop_api.category;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }

    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(this.categoryService.getCategoryById(id));
    }

    @GetMapping("/{name:[a-zA-Z]+}")
    public ResponseEntity<CategoryDto> getCategoryByName(@PathVariable String name) {
        return ResponseEntity.ok(this.categoryService.getCategoryByName(name));
    }

    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(@Valid @RequestBody CategoryRequest request) {
        return ResponseEntity.status(CREATED).body(this.categoryService.addCategory(request));
    }

    @PutMapping("/{id:[0-9]+}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.categoryService.updateCategory(request, id));
    }

    @DeleteMapping("/{id:[0-9]+}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        this.categoryService.deleteCategoryById(id);
        return ResponseEntity.ok("Category is deleted successfully!");
    }
}
