package com.ojtproject.phonebook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ojtproject.phonebook.form.DeleteForm;
import com.ojtproject.phonebook.form.RegistForm;
import com.ojtproject.phonebook.form.SearchForm;
import com.ojtproject.phonebook.form.UpdateForm;
import com.ojtproject.phonebook.service.DeleteService;
import com.ojtproject.phonebook.service.MessageService;
import com.ojtproject.phonebook.service.RegistService;
import com.ojtproject.phonebook.service.SearchService;
import com.ojtproject.phonebook.service.UpdateService;

@Controller
public class PhoneBookController {
	@Autowired
	private SearchService search;
	@Autowired
	private RegistService regist;
	@Autowired
	private UpdateService update;
	@Autowired
	private DeleteService delete;


	/**トップページを表示*/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav) {
		search.search(null, mav);
		search.createPages(1, null, mav);
		return mav;
	}

	/**検索ロジックを呼び出して検索ページへ遷移*/
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(SearchForm input, ModelAndView mav) {
		String keyword = input.getKeyword();
		search.search(keyword, mav);
		search.createPages(1, keyword, mav);
		return mav;
	}

	/**前ページへ遷移*/
	@RequestMapping(value = "/prevPaging", method = RequestMethod.GET)
	public ModelAndView prevPaging(@RequestParam(value = "pageNumber", required = true) int pageNumber,
			SearchForm input, ModelAndView mav ) {
		String keyword = input.getKeyword();
		search.createPages(--pageNumber, keyword, mav);
		return mav;
	}
	/**次ページへ遷移*/
	@RequestMapping(value = "/nextPaging", method = RequestMethod.GET)
	public ModelAndView nextPaging(@RequestParam(value = "pageNumber", required = true) int pageNumber,
			SearchForm input, ModelAndView mav ) {
		String keyword = input.getKeyword();
		search.createPages(++pageNumber, keyword, mav);
		return mav;
	}

	/**登録ページへの遷移*/
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public ModelAndView regist(ModelAndView mav) {
		List<String> message = new ArrayList<>();
		message.add(MessageService.REGIST_NEW);
		mav.addObject("msg", message);
		mav.setViewName("/regist");
		return mav;
	}

	/**登録ロジックを呼び出して登録を行う*/
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public ModelAndView regist(RegistForm input, ModelAndView mav) {
		regist.regist(input, mav);
		return mav;
	}

	/**更新ページへの遷移*/
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView update(ModelAndView mav, @RequestParam(value = "id", required = true) int id,
			@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "phoneNumber", required = true) String phoneNumber) {
		update.updateInIt(id, name, phoneNumber, mav);
		mav.setViewName("/update");
		return mav;
	}

	/**更新ロジックを呼び出して更新を行う*/
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(UpdateForm input, ModelAndView mav) {
		update.update(input, mav);
		return mav;
	}

	/**削除ロジックを呼び出して削除を行う*/
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(DeleteForm input,
			@RequestParam(value = "pageNumber", required = true) int pageNumber,
			ModelAndView mav) {
		delete.delete(input, pageNumber, mav);
		return mav;
	}
}