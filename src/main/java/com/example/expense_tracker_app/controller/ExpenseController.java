package com.example.expense_tracker_app.controller;

import com.example.expense_tracker_app.dto.ExpenseDto;
import com.example.expense_tracker_app.entity.Expense;
import com.example.expense_tracker_app.service.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Expense Resource",
        description = "CRUD REST APIs for Expense Resource - Create Expense, Update Expense, Read Expense, Delete Expense"
)
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Operation(
            summary = "Create Expense REST API/.",
            description = "Create Expense REST API to save Expense into database."
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        return new ResponseEntity(expenseService.createExpense(expenseDto), HttpStatus.CREATED);
    }

    @Operation(
            summary = "Read Expense REST API/.",
            description = "Read Expense REST API to read Expense from database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable Long id) {
        return ResponseEntity.ok(expenseService.getExpenseById(id));
    }

    @Operation(
            summary = "Get All Categories REST API/.",
            description = "Get All Categories REST API to read all categories from the database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @GetMapping("/")
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @Operation(
            summary = "Update Expense REST API/.",
            description = "Update Expense REST API to update an existing Expense."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@RequestBody ExpenseDto expenseDto, @PathVariable Long id) {
        return new ResponseEntity(expenseService.updateExpense(id, expenseDto), HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Expense REST API/.",
            description = "Delete Expense REST API from database."
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS 200 OK"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpenseById(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity("Expense Deleted Successfully", HttpStatus.OK);
    }
}
