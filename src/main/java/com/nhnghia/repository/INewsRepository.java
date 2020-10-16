package com.nhnghia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhnghia.entity.NewsEntity;

public interface INewsRepository extends JpaRepository<NewsEntity, Long>{

}
