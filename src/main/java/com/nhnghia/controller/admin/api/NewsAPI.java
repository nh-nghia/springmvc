package com.nhnghia.controller.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhnghia.dto.NewsDTO;
import com.nhnghia.service.INewsService;

@RestController(value = "newsAPIOfAdmin")
@RequestMapping("/api")
public class NewsAPI {

	@Autowired
	private INewsService newsService;

	@PostMapping("/news")
	public NewsDTO createNews(@RequestBody NewsDTO newsDTO) {

		return newsService.save(newsDTO);
	}

	@PutMapping("/news")
	public NewsDTO updateNews(@RequestBody NewsDTO newsDTO) {

		return newsService.save(newsDTO);
	}

	@DeleteMapping("/news")
	public void deleteNews(@RequestBody Long[] ids) {
		newsService.delete(ids);
	}

}
