package com.nhnghia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhnghia.converter.CategoryConverter;
import com.nhnghia.dto.CategoryDTO;
import com.nhnghia.entity.CategoryEntity;
import com.nhnghia.repository.ICategoryRepository;
import com.nhnghia.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> categoryDTOList = new ArrayList<>();
		List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
		for (CategoryEntity item : categoryEntityList) {
			CategoryDTO categoryDTO = categoryConverter.convertToCategoryDTO(item);
			categoryDTOList.add(categoryDTO);
		}
		
		return categoryDTOList;
	}

}
