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

		String areaCode = input.getAreaCode();
		String cityCode = input.getCityCode();
		String identificationCode = input.getIdentificationCode();
		String phoneNumber = areaCode + "-" + cityCode + "-" + identificationCode;

		boolean isCorrectName = ValidationUtil.validateName(name);
		boolean isCorrectCodeByOneBox = ValidationUtil.validateOneBox(areaCode) && ValidationUtil.validateOneBox(cityCode)
				&& ValidationUtil.validateOneBox(identificationCode);
		boolean isCorrectPhoneNumber = ValidationUtil.validateTotalBoxes(areaCode + cityCode + identificationCode);

		if (!isCorrectName && !isCorrectCodeByOneBox && !isCorrectPhoneNumber) {
			mav.addObject("msg", MessageService.NAME_LIMIT + MessageService.PHONENUMBER_FAULT);
			mav.addObject("name", name);
			mav.addObject("areaCode", areaCode);
			mav.addObject("cityCode", cityCode);
			mav.addObject("identificationCode", identificationCode);
			return;
		}else if (!isCorrectCodeByOneBox) {
			mav.addObject("msg", MessageService.PHONENUMBER_FAULT);
			mav.addObject("name", name);
			mav.addObject("areaCode", areaCode);
			mav.addObject("cityCode", cityCode);
			mav.addObject("identificationCode", identificationCode);
			return;
		} else if (!isCorrectName) {
			mav.addObject("msg", MessageService.NAME_LIMIT);
			mav.addObject("name", name);
			mav.addObject("areaCode", areaCode);
			mav.addObject("cityCode", cityCode);
			mav.addObject("identificationCode", identificationCode);
			return;
		}

		phoneBookRepository.regist(name, phoneNumber);
		registMsg(name, phoneNumber, mav);


	}

	private static void registMsg(String inputedName, String inputedPhoneNumber, ModelAndView mav) {
		mav.addObject("msg", inputedName + MessageService.SUCCESS_ACCOUNT);
	}

}
