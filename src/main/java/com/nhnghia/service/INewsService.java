package com.nhnghia.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.nhnghia.dto.NewsDTO;

public interface INewsService {

	List<NewsDTO> findAll(Pageable pageable);

	int getTotalItems();

	NewsDTO findById(long id);

//	NewsDTO insert(NewsDTO insertNewsDTO);
//
//	NewsDTO update(NewsDTO updateNewsDTO);

	NewsDTO save(NewsDTO newsDTO);
	
	void delete(Long[] ids);

}
