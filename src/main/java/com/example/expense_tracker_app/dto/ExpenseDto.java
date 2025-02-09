package com.example.expense_tracker_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(
        description = "Expense DTO (Data Transfer Object) to transfer data between client and server"
)
public record ExpenseDto(Long id,
                         @Schema(
                                 description = "Expense Amount"
                         )
                         BigDecimal amount,
                         @Schema(
                                 description = "Expense created Date"
                         )
                         LocalDate date,
                         @Schema(
                                 description = "Associated Expense Category"
                         )
                         CategoryDto categoryDto) {
}
