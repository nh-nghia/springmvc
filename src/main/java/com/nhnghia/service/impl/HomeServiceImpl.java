package com.nhnghia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nhnghia.service.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService {

	@Override
	public List<String> loadMenu() {
		
		List<String> listMenu = new ArrayList<>();
		listMenu.add("About");
		listMenu.add("Services");
		listMenu.add("Contact");
		listMenu.add("Using");
		listMenu.add("Interceptor");
		
		return listMenu;
	}

}
