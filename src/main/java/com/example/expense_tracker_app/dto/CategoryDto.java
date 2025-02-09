package com.example.expense_tracker_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Category DTO (Data Transfer Object) to transfer data between client and server"
)
public record CategoryDto(Long id,
                          @Schema(
                                  description = "Category Name"
                          )
                          String name) {

    // Using record we need not generate all the boiler plate code it will be handled by itself.
}
