	package com.ojtproject.phonebook.service;

import java.util.List;

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

		String areaCode = input.getAreaCode();
		String cityCode = input.getCityCode();
		String identificationCode = input.getIdentificationCode();
		String phoneNumber = areaCode + "-" + cityCode + "-" + identificationCode;

		List<String> message = ValidationUtil.validateName(name);
		message.addAll(ValidationUtil.validateOneBox(areaCode, cityCode, identificationCode));
		message.addAll(ValidationUtil.validateTotalBoxes(areaCode, cityCode, identificationCode));

		if(!message.isEmpty()) {
			mav.addObject("name", name);
			mav.addObject("areaCode", areaCode);
			mav.addObject("cityCode", cityCode);
			mav.addObject("identificationCode", identificationCode);
			mav.addObject("msg", message);
			return;
		}

		phoneBookRepository.regist(name, phoneNumber);
		registMsg(name, phoneNumber, mav);
	}

	private static void registMsg(String inputedName, String inputedPhoneNumber, ModelAndView mav) {
		mav.addObject("msg", inputedName + MessageService.SUCCESS_ACCOUNT);
	}

}
