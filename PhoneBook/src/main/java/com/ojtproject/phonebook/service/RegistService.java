package com.ojtproject.phonebook.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ojtproject.phonebook.dao.PhoneBookRepository;
import com.ojtproject.phonebook.form.RegistForm;

/**
 * 登録クラス
 */
@Service
public class RegistService {
	@Autowired
	private HttpSession session;
	@Autowired
	private PhoneBookRepository phoneBookRepository;

	public void registInIt() {

	}

	public void regist(RegistForm input, ModelAndView mav) {


		String name = input.getName(); 					//入力された名前を取得
		String phoneNumber = input.getAreaCode() + input.getCityCode() + input.getIdentificationCode();	//入力された電話番号を取得

		phoneBookRepository.regist(name, phoneNumber);


	}
}
