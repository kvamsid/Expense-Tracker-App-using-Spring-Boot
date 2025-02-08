package com.example.expense_tracker_app.repository;

import com.example.expense_tracker_app.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    //Spring Data JPA does al the implementation and also manages transactions for this repository
    // CRUD operations can be performed as we have extended JpaRepository
}
