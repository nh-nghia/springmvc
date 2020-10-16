package com.nhnghia.converter;

import org.springframework.stereotype.Component;

import com.nhnghia.dto.CategoryDTO;
import com.nhnghia.entity.CategoryEntity;

@Component
public class CategoryConverter {

	public CategoryDTO convertToCategoryDTO(CategoryEntity categoryEntity) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(categoryEntity.getId());
		categoryDTO.setName(categoryEntity.getName());
		categoryDTO.setCode(categoryEntity.getCode());

		return categoryDTO;
	}

	public CategoryEntity convertToCategoryEntity(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setName(categoryDTO.getName());
		categoryEntity.setCode(categoryDTO.getCode());

		return categoryEntity;
	}

}
