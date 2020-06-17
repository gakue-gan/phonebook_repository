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

		int id = input.getId();
		String name = input.getName(); //入力された名前を取得

		String areaCode = input.getAreaCode();
		String cityCode = input.getCityCode();
		String identificationCode = input.getIdentificationCode();
		String phoneNumber = areaCode + "-" + cityCode + "-" + identificationCode; //入力された電話番号を取得

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
		} else if (!ValidationUtil.validateName(name)) {
			mav.addObject("msg", MessageService.NAME_LIMIT);
			mav.addObject("name", name);
			mav.addObject("areaCode", areaCode);
			mav.addObject("cityCode", cityCode);
			mav.addObject("identificationCode", identificationCode);
			return;
		}

		phoneBookRepository.update(id, name, phoneNumber);

		updateMsg(name, phoneNumber, mav);
	}


	private static void updateMsg(String inputedName, String inputedPhoneNumber, ModelAndView mav) {
		mav.addObject("msg", inputedName + MessageService.EDIT_SUCCESS);

	}

}

