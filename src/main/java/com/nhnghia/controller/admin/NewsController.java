package com.nhnghia.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nhnghia.dto.NewsDTO;
import com.nhnghia.service.ICategoryService;
import com.nhnghia.service.INewsService;
import com.nhnghia.util.MessageUtil;

@Controller(value = "newsControllerOfAdmin")
public class NewsController {

	@Autowired
	private INewsService newsService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private MessageUtil messageUtil;

	@RequestMapping(value = "/admin-news/list", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit,
			HttpServletRequest request) {
		NewsDTO model = new NewsDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/news/list");
		// getOffset (page - 1) * limit
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(newsService.findAll(pageable));
		model.setTotalItems(newsService.getTotalItems());
		model.setTotalPages((int) Math.ceil((double) model.getTotalItems() / model.getLimit()));

		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.showMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}

		mav.addObject("model", model);

		return mav;
	}

	@RequestMapping(value = "/admin-news/edit", method = RequestMethod.GET)
	// required = false, tránh tình trạng thêm mới thì không có id sẽ gây lỗi
	public ModelAndView editNews(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/news/edit");
		NewsDTO model = new NewsDTO();
		if (id != null) {
			model = newsService.findById(id);
		}

		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.showMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}

		mav.addObject("categories", categoryService.findAll());
		mav.addObject("model", model);

		return mav;
	}

}
