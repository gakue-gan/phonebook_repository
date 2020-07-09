package com.ojtproject.phonebook.service;

import java.util.ArrayList;
import java.util.List;

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

	public void updateInIt (int id, String name, String phoneNumber, String address,  ModelAndView mav) {
		// 次の画面に引き継ぐパラメータをキーとバリューの形式で渡す。
				// したの例はバリューにString型の文字列を渡しているが、別にオブジェクト型でもOK

				String[] code = phoneNumber.split("-", 0);
				String areaCode = code[0];
				String cityCode = code[1];
				String identificationCode = code[2];

				List<String> msg = new ArrayList<>();
				msg.add(name + MessageService.EDIT_ACCOUNT);
				mav.addObject("msg", msg);
				mav.addObject("id", id);
				mav.addObject("name", name);
				mav.addObject("areaCode", areaCode);
				mav.addObject("cityCode", cityCode);
				mav.addObject("identificationCode", identificationCode);
				mav.addObject("address", address);
				// 次に遷移するHTMLの名前を指定する
	}


	public void update(UpdateForm input, ModelAndView mav) {

		int id = input.getId();
		String name = input.getName(); //入力された名前を取得

		String areaCode = input.getAreaCode();
		String cityCode = input.getCityCode();
		String identificationCode = input.getIdentificationCode();
		String phoneNumber = areaCode + "-" + cityCode + "-" + identificationCode; //入力された電話番号を取得

		String address = input.getAddress();

		List<String> message = ValidationUtil.validateName(name);
		message.addAll(ValidationUtil.validateOneBox(areaCode, cityCode, identificationCode));
		message.addAll(ValidationUtil.validateTotalBoxes(areaCode, cityCode, identificationCode));
		message.addAll(ValidationUtil.validateAddress(address));

		if(!message.isEmpty()) {
			mav.addObject("id", id);
			mav.addObject("name", name);
			mav.addObject("areaCode", areaCode);
			mav.addObject("cityCode", cityCode);
			mav.addObject("identificationCode", identificationCode);
			mav.addObject("address", address);
			mav.addObject("msg", message);
			return;
		}
		mav.addObject("id", id);
		phoneBookRepository.update(id, name, phoneNumber, address);
		updateMsg(name, phoneNumber, mav);
	}

	private static void updateMsg(String inputedName, String inputedPhoneNumber, ModelAndView mav) {

		List<String> message = new ArrayList<>();
		message.add(inputedName + MessageService.EDIT_SUCCESS);
		mav.addObject("msg", message);

	}

}
