package com.mabotalb.nova_shop_api.category;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class CategoryRequest {

    @NotNull(message = "Category name is required")
    @NotEmpty(message = "Category name is required")
    @Size(min = 3, message = "Category name must be at least 3 characters")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Category name must contain characters only")
    private String name;
}
