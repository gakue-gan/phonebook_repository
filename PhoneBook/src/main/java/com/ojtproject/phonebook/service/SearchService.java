package com.ojtproject.phonebook.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ojtproject.phonebook.dao.PhoneBookRepository;
import com.ojtproject.phonebook.entity.PhoneBookEntity;
import com.ojtproject.phonebook.form.SearchForm;
import com.ojtproject.phonebook.form.SearchResultForm;
import com.ojtproject.phonebook.util.ValidationUtil;

/**
 * 検索クラス
 */
@Service
public class SearchService {
	@Autowired
	private HttpSession session;
	@Autowired
	private PhoneBookRepository phoneBookRepository;

	/**入力された名前と電話帳リストにある名前を比較して合致するものをListに格納するメソッド*/
	public void search(SearchForm input, ModelAndView mav) {
		List<PhoneBookEntity> phoneBookList = null;
		String keyword = input.getKeyword(); //入力された名前を取得

		List<SearchResultForm> searchList = new ArrayList<>();
		if (keyword == null) {
			phoneBookList = phoneBookRepository.findAll();
		} else if ("".equals(keyword)) {
			// 全件検索
			phoneBookList = phoneBookRepository.findAll();
		} else if (!ValidationUtil.validateName(keyword)) {
			// 入力値が不正な場合全件表示
			phoneBookList = phoneBookRepository.findAll();

		} else if (!"".equals(keyword)) {
			// キーワード検索
			phoneBookList = phoneBookRepository.find(keyword);
		}
		session.setAttribute("phoneBookList", phoneBookList);
		for (int i = 0; i < phoneBookList.size(); i++) {
			PhoneBookEntity entity = phoneBookList.get(i);
			SearchResultForm sf = new SearchResultForm();
			sf.setId(entity.getId());
			sf.setName(entity.getName());
			sf.setPhoneNumber(entity.getPhoneNumber());
			searchList.add(sf);
		}
		mav.addObject("searchList", searchList);
		mav.addObject("keyword", keyword);
		mav.setViewName("search");
		SearchService.searchMsg(searchList, keyword, mav);
	}

	private static void searchMsg(List<SearchResultForm> searchList, String inputName, ModelAndView mav) {

		if (inputName == null) {
			mav.addObject("msg", searchList.size() + MessageService.SEARCH_HIT_COUNT
					+ searchList.size() + MessageService.SEARCH_HIT_DISPLAYEDCOUNT);
		} else if ("".equals(inputName)) {
			mav.addObject("msg", searchList.size() + MessageService.SEARCH_HIT_COUNT
					+ searchList.size() + MessageService.SEARCH_HIT_DISPLAYEDCOUNT);
		} else if (!ValidationUtil.validateName(inputName)) {
			mav.addObject("msg", MessageService.SEARCH_LIMIT);
		} else if (searchList.size() == 0) {
			mav.addObject("msg", MessageService.SEARCH_NOT_HIT);
		} else {
			mav.addObject("msg", searchList.size() + MessageService.SEARCH_HIT_COUNT
					+ searchList.size() + MessageService.SEARCH_HIT_DISPLAYEDCOUNT);
		}
	}
}