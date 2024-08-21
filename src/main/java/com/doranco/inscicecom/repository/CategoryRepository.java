package com.doranco.inscicecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doranco.inscicecom.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
