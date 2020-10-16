package com.nhnghia.converter;

import org.springframework.stereotype.Component;

import com.nhnghia.dto.NewsDTO;
import com.nhnghia.entity.NewsEntity;

@Component
public class NewsConverter {
	
	public NewsDTO convertToNewsDTO(NewsEntity newsEntity) {
		NewsDTO newsDTO = new NewsDTO();
		newsDTO.setId(newsEntity.getId());
		newsDTO.setTitle(newsEntity.getTitle());
		newsDTO.setThumbnail(newsEntity.getThumbnail());
		newsDTO.setShortDescription(newsEntity.getShortDescription());
		newsDTO.setContent(newsEntity.getContent());
		newsDTO.setCategoryCode(newsEntity.getCategoryEntity().getCode());
		newsDTO.setCreatedDate(newsEntity.getCreatedDate());
		newsDTO.setModifiedDate(newsEntity.getModifiedDate());
		newsDTO.setCreatedBy(newsEntity.getCreatedBy());
		newsDTO.setModifiedBy(newsEntity.getModifiedBy());
		
		return newsDTO;
	}
	
	public NewsEntity convertToNewsEntity(NewsDTO newsDTO) {
		NewsEntity newsEntity = new NewsEntity();
		newsEntity.setTitle(newsDTO.getTitle());
		newsEntity.setThumbnail(newsDTO.getThumbnail());
		newsEntity.setShortDescription(newsDTO.getShortDescription());
		newsEntity.setContent(newsDTO.getContent());
		
		return newsEntity;
	}
	
	// trả về newsEntity dựa trên entity đã có rồi 
	public NewsEntity convertToNewsEntity(NewsEntity newsEntity, NewsDTO newsDTO) {
		newsEntity.setTitle(newsDTO.getTitle());
		newsEntity.setThumbnail(newsDTO.getThumbnail());
		newsEntity.setShortDescription(newsDTO.getShortDescription());
		newsEntity.setContent(newsDTO.getContent());
		
		return newsEntity;
	}
	
}
