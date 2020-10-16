package com.nhnghia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nhnghia.converter.NewsConverter;
import com.nhnghia.dto.NewsDTO;
import com.nhnghia.entity.CategoryEntity;
import com.nhnghia.entity.NewsEntity;
import com.nhnghia.repository.ICategoryRepository;
import com.nhnghia.repository.INewsRepository;
import com.nhnghia.service.INewsService;

@Service
public class NewsServiceImpl implements INewsService {

	@Autowired
	private INewsRepository newsRepository;

	@Autowired
	private ICategoryRepository categoryRepository;

	@Autowired
	private NewsConverter newsConverter;

	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		List<NewsDTO> newsDTOList = new ArrayList<>();
		List<NewsEntity> newsEntityList = newsRepository.findAll(pageable).getContent();
		for (NewsEntity item : newsEntityList) {
			NewsDTO newsDTO = newsConverter.convertToNewsDTO(item);
			newsDTOList.add(newsDTO);
		}

		return newsDTOList;
	}

	@Override
	public int getTotalItems() {

		return (int) newsRepository.count();
	}

	@Override
	public NewsDTO findById(long id) {
		NewsEntity newsEntity = newsRepository.findOne(id);

		return newsConverter.convertToNewsDTO(newsEntity);
	}

//	@Override
//	@Transactional
//	public NewsDTO insert(NewsDTO insertNewsDTO) {
//		CategoryEntity categoryEntity = categoryRepository.findOneByCode(insertNewsDTO.getCategoryCode());
//		NewsEntity newsEntity = newsConverter.convertToNewsEntity(insertNewsDTO);
//		newsEntity.setCategoryEntity(categoryEntity);
//		newsEntity = newsRepository.save(newsEntity);
//
//		return newsConverter.convertToNewsDTO(newsEntity);
//	}
//
//	@Override
//	@Transactional
//	public NewsDTO update(NewsDTO updateNewsDTO) {
//		NewsEntity oldNews = newsRepository.findOne(updateNewsDTO.getId());
//		CategoryEntity categoryEntity = categoryRepository.findOneByCode(updateNewsDTO.getCategoryCode());
//		oldNews.setCategoryEntity(categoryEntity);
//		NewsEntity updateNews = newsConverter.convertToNewsEntity(oldNews, updateNewsDTO);
//
//		return newsConverter.convertToNewsDTO(newsRepository.save(updateNews));
//	}

	// thay cho 2 hàm trên
	@Override
	@Transactional
	public NewsDTO save(NewsDTO newsDTO) {
		// tìm category theo code
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newsDTO.getCategoryCode());
		NewsEntity newsEntity = new NewsEntity();
		// cập nhật
		if (newsDTO.getId() != null) {
			// lấy bài viết cũ lên
			NewsEntity oldNews = newsRepository.findOne(newsDTO.getId());
			// set category cho bài viết cũ
			oldNews.setCategoryEntity(categoryEntity);
			// convert từ bài viết cũ -> bài viết mới (dựa vào bài viết cũ để override những thông tin thay đổi)
			newsEntity = newsConverter.convertToNewsEntity(oldNews, newsDTO);
		// thêm mới
		} else {
			// dto gửi về server như thế nào thì convert về entity như vậy và set category
			newsEntity = newsConverter.convertToNewsEntity(newsDTO);
			newsEntity.setCategoryEntity(categoryEntity);
		}
		// lưu xuống và return lại dto từ entity
		return newsConverter.convertToNewsDTO(newsRepository.save(newsEntity));
	}

	@Override
	@Transactional
	public void delete(Long[] ids) {
		for (Long id : ids) {
			newsRepository.delete(id);
		}
	}

}
