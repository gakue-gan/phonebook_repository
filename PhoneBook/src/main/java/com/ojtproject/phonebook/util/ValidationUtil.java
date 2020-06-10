package com.ojtproject.phonebook.util;

public class ValidationUtil {

	public static boolean validatePhoneCode(String inputedPhoneNumber) {
		boolean isCorrect = true;

		try {
			Long.parseLong(inputedPhoneNumber);

			int len = inputedPhoneNumber.length();
			if (len <= 9 || 12 <= len) {
				isCorrect = false;
			}

		} catch (NumberFormatException e) {
			isCorrect = false;
		}

		return isCorrect;
	}

	public static boolean validateName(String inputedName) {
		boolean isCorrect = true;

		int len = inputedName.length();
		if (len >= 21) {
			isCorrect = false;
		}

		return isCorrect;
	}

}
