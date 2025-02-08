package com.example.expense_tracker_app.service.impl;

import com.example.expense_tracker_app.dto.ExpenseDto;
import com.example.expense_tracker_app.entity.Category;
import com.example.expense_tracker_app.entity.Expense;
import com.example.expense_tracker_app.mapper.ExpenseMapper;
import com.example.expense_tracker_app.repository.CategoryRepository;
import com.example.expense_tracker_app.repository.ExpenseRepository;
import com.example.expense_tracker_app.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ExpenseImpl implements ExpenseService {

    ExpenseRepository expenseRepository;

    CategoryRepository categoryRepository;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = ExpenseMapper.maptoExpense(expenseDto);
        return ExpenseMapper.maptoExpenseDto(expenseRepository.save(expense));
    }

    @Override
    public ExpenseDto getExpenseById(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(()-> new RuntimeException("Expense not found: "+id));
        return ExpenseMapper.maptoExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        List<ExpenseDto> expenseDtos = new ArrayList<>();
        expenses.forEach(expense -> expenseDtos.add(ExpenseMapper.maptoExpenseDto(expense)));
        return expenseDtos;
    }

    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(id).orElseThrow(()-> new RuntimeException("Expense not found: "+id));
        expense.setAmount(expenseDto.amount());
        expense.setDate(expenseDto.date());
        if(expenseDto.categoryDto() != null){
            Category category = categoryRepository.findById(expenseDto.categoryDto().id()).orElseThrow(() -> new RuntimeException("Category not found: "+expenseDto.categoryDto().id()));
            expense.setCategory(category);
        }
        return ExpenseMapper.maptoExpenseDto(expenseRepository.save(expense));
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(()-> new RuntimeException("Expense not found: "+id));
        expenseRepository.delete(expense);
    }
}
