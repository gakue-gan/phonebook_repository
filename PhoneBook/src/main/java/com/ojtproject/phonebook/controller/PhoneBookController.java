package com.ojtproject.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ojtproject.phonebook.form.RegistForm;
import com.ojtproject.phonebook.form.SearchForm;
import com.ojtproject.phonebook.service.RegistService;
import com.ojtproject.phonebook.service.SearchService;

@Controller
public class PhoneBookController {
	@Autowired
	private SearchService search;
	@Autowired
	private RegistService regist;

	/**トップページを表示*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		return search(new SearchForm(), mav);
	}

	/**検索ロジックを呼び出して検索ページへ遷移*/
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(SearchForm input, ModelAndView mav) {
		search.search(input, mav);
		return mav;
	}

	/**登録ページへの遷移*/
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public ModelAndView regist(ModelAndView mav) {
		return regist(new RegistForm(), mav);
	}


	/**登録ロジックを呼び出して登録を行う*/
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public ModelAndView regist(RegistForm input, ModelAndView mav) {
		regist.regist(input, mav);
		return mav;
	}
}