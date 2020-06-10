package com.ojtproject.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ojtproject.phonebook.dao.PhoneBookRepository;
import com.ojtproject.phonebook.form.UpdateForm;
import com.ojtproject.phonebook.util.ValidationUtil;

/**
 * 更新クラス
 */
@Service
public class UpdateService {
	@Autowired
	private PhoneBookRepository phoneBookRepository;

	public void update(UpdateForm input, ModelAndView mav) {

		String name = input.getName(); //入力された名前を取得
		String phoneNumber = input.getAreaCode() + input.getCityCode() + input.getIdentificationCode(); //入力された電話番号を取得

		updateMsg(name, phoneNumber, mav);

		if (!ValidationUtil.validateName(name)) {
			return;
		}
		if (!ValidationUtil.validatePhoneCode(phoneNumber)) {
			return;
		}
		phoneBookRepository.update(name, phoneNumber);

	}

	private static void updateMsg(String inputedName, String inputedPhoneNumber, ModelAndView mav) {
		if (inputedName == null || inputedPhoneNumber == null) {
			return;
		}

		if ("".equals(inputedName) || "".equals(inputedPhoneNumber)) {
			mav.addObject("msg", MessageService.INPUT_ACCOUNT_EMPTY);
		}

	}

}
