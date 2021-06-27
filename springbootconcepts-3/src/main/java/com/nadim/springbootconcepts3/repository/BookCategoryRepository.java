package com.nadim.springbootconcepts3.repository;

import com.nadim.springbootconcepts3.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer>{

}
