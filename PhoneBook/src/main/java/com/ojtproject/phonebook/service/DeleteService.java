package com.ojtproject.phonebook.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ojtproject.phonebook.dao.PhoneBookRepository;
import com.ojtproject.phonebook.form.DeleteForm;

@Service
public class DeleteService {
	@Autowired
	private SearchService search;
	@Autowired
	private HttpSession session;

	@Autowired
	private PhoneBookRepository phoneBookRepository;

	public void delete(DeleteForm input, int pageNumber, ModelAndView mav) {

		int id = input.getId();
		String name = input.getName();

		phoneBookRepository.delete(id);
		deleteMsg(name, mav);

		search.search(null, mav);
		search.createPages(pageNumber, null, mav);
	}

	public void deleteMsg(String name, ModelAndView mav){
		List<String> message = new ArrayList<>();
		message.add(name + "さんのデータが削除されました。");

		mav.addObject("msg", message);
	}
}


