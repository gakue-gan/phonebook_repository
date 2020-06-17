package com.ojtproject.phonebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ojtproject.phonebook.dao.PhoneBookRepository;
import com.ojtproject.phonebook.form.DeleteForm;

@Service
public class DeleteService {
	@Autowired
	private PhoneBookRepository phoneBookRepository;

	public void delete(DeleteForm input, ModelAndView mav) {

		int id = input.getId();

		// deleteMsg(name, phoneNumber, mav);

		phoneBookRepository.delete(id);



	}
}
