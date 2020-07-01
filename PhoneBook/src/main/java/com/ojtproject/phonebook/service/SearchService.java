package com.ojtproject.phonebook.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ojtproject.phonebook.dao.PhoneBookRepository;
import com.ojtproject.phonebook.entity.PhoneBookEntity;
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

	public void search(String keyword, ModelAndView mav) {

		List<PhoneBookEntity> phoneBookList = null;
		if(!ValidationUtil.validateKeyword(keyword).isEmpty()) {
			// 入力値が不正な場合全件表示
			phoneBookList = phoneBookRepository.findAll();

		} else {
			// キーワード検索
			phoneBookList = phoneBookRepository.find(keyword);
		}
		// セッションにphoneBookListを格納
		session.setAttribute("phoneBookList", phoneBookList);

	}

	public void createPages(int pageNumber, String keyword, ModelAndView mav) {

		List<PhoneBookEntity> phoneBookList = (ArrayList<PhoneBookEntity>) session.getAttribute("phoneBookList");
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
		mav.addObject("keyword", keyword);
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName("search");
		searchMsg(searchList, pageNumber, keyword, mav);
	}

	private void searchMsg(List<SearchResultForm> searchList, int pageNumber,
			String keyword, ModelAndView mav) {
		List<PhoneBookEntity> phoneBookList = (ArrayList<PhoneBookEntity>) session.getAttribute("phoneBookList");

		List<String> msg = new ArrayList<>();

		List<String> deletedList = (List<String>)mav.getModelMap().getAttribute("msg");
		if(deletedList != null) {
			msg.addAll(deletedList);
		}
		msg.addAll(ValidationUtil.validateKeyword(keyword));
		if(msg.isEmpty()) {
			msg.add(keyword + "を検索します。");
		}

		if (searchList.size() == 0) {
			msg.add(MessageService.SEARCH_NOT_HIT);
		} else {
			msg.add(phoneBookList.size() + MessageService.SEARCH_HIT_COUNT
					+ (searchList.size() + 15 * (pageNumber - 1)) + MessageService.SEARCH_HIT_DISPLAYEDCOUNT);
		}

		mav.addObject("msg", msg);

	}
}