package com.example.expense_tracker_app.mapper;

import com.example.expense_tracker_app.dto.CategoryDto;
import com.example.expense_tracker_app.dto.ExpenseDto;
import com.example.expense_tracker_app.entity.Category;
import com.example.expense_tracker_app.entity.Expense;

public class ExpenseMapper {

    public static ExpenseDto maptoExpenseDto(Expense expense) {
        CategoryDto categoryDto = new CategoryDto(expense.getCategory().getId(), expense.getCategory().getName());
        ExpenseDto expenseDto = new ExpenseDto(expense.getId(), expense.getAmount(), expense.getDate(), CategoryMapper.maptoCategoryDto(expense.getCategory()));
        return expenseDto;
    }

    public static Expense maptoExpense(ExpenseDto expenseDto) {
        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());
        category.setName(expenseDto.categoryDto().name());
        Expense expense = new Expense();
        expense.setId(expenseDto.id());
        expense.setAmount(expenseDto.amount());
        expense.setDate(expenseDto.date());
        expense.setCategory(category);
        return expense;
    }
}
