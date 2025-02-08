package com.example.expense_tracker_app.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ExpenseDto(Long id, BigDecimal amount, LocalDate date, CategoryDto categoryDto) {
}
