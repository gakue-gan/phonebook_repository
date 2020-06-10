package com.ojtproject.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ojtproject.phonebook.dao.PhoneBookRepository;
import com.ojtproject.phonebook.form.RegistForm;
import com.ojtproject.phonebook.util.ValidationUtil;

/**
 * 登録クラス
 */
@Service
public class RegistService {
	@Autowired
	private PhoneBookRepository phoneBookRepository;

	public void regist(RegistForm input, ModelAndView mav) {

		String name = input.getName(); //入力された名前を取得
		String phoneNumber = input.getAreaCode() + input.getCityCode() + input.getIdentificationCode(); //入力された電話番号を取得

		registMsg(name, phoneNumber, mav);

		if (!ValidationUtil.validateName(name)) {
			return;
		}
		if (!ValidationUtil.validatePhoneCode(phoneNumber)) {
			return;
		}
		phoneBookRepository.regist(name, phoneNumber);

	}

	private static void registMsg(String inputedName, String inputedPhoneNumber, ModelAndView mav) {
		if (inputedName == null || inputedPhoneNumber == null) {
			return;
		}

		if ("".equals(inputedName) || "".equals(inputedPhoneNumber)) {
			mav.addObject("msg", MessageService.INPUT_ACCOUNT_EMPTY);
		}

	}

}
