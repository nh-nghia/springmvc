package com.nhnghia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhnghia.entity.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
	
	CategoryEntity findOneByCode(String code);

}
