package com.doranco.inscicecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doranco.inscicecom.model.FAQ;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Long>{
	List<FAQ> findAllByProductId(Long productId);
}
