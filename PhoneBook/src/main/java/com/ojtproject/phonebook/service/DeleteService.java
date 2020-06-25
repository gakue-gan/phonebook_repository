package com.ojtproject.phonebook.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ojtproject.phonebook.dao.PhoneBookRepository;
import com.ojtproject.phonebook.entity.PhoneBookEntity;
import com.ojtproject.phonebook.form.DeleteForm;
import com.ojtproject.phonebook.form.SearchResultForm;

@Service
public class DeleteService {
	@Autowired
	private HttpSession session;

	@Autowired
	private PhoneBookRepository phoneBookRepository;

	public void delete(DeleteForm input, ModelAndView mav) {

		int id = input.getId();
		String name = input.getName();

		phoneBookRepository.delete(id);
		deleteMsg(name, mav);


		List<PhoneBookEntity> phoneBookList = null;
		phoneBookList = phoneBookRepository.findAll();

		// セッションにphoneBookListを格納
		session.setAttribute("phoneBookList", phoneBookList);

		int pageNumber = 1;
		mav.addObject("pageNumber", pageNumber);

		List<SearchResultForm> searchList = new ArrayList<>();
		int len = phoneBookList.size();
		for (int i = 15 * (pageNumber - 1); i < Math.min((15 * pageNumber), len); i++) {
			PhoneBookEntity entity = phoneBookList.get(i);
			SearchResultForm sf = new SearchResultForm();
			sf.setId(entity.getId());
			sf.setName(entity.getName());
			sf.setPhoneNumber(entity.getPhoneNumber());
			searchList.add(sf);
		}
		boolean existsNext = len > 15 * pageNumber ? true: false;

		mav.addObject("existsNext", existsNext);
		mav.addObject("searchList", searchList);
		mav.addObject("keyword", null);
		mav.setViewName("search");

	}

	public void deleteMsg(String name, ModelAndView mav){
		List<String> message = new ArrayList<>();
		message.add(name + "さんのデータが削除されました。");
		mav.addObject("msg", message);
	}
}


