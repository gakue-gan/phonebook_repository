package com.ojtproject.phonebook.util;

public class ValidationUtil {

	public static boolean validateOneBox(String inputedPhoneNumber) {
		boolean isCorrect = true;

		if("".equals(inputedPhoneNumber) || inputedPhoneNumber == null) {
			isCorrect = false;
		}
		try {
			Long.parseLong(inputedPhoneNumber);
			int len = inputedPhoneNumber.length();
			if (len <= 2 || 5 <= len) {
				isCorrect = false;
			}

		} catch (NumberFormatException e) {
			isCorrect = false;
		}

		return isCorrect;
	}

	public static boolean validateTotalBoxes(String inputedPhoneNumber) {
		boolean isCorrect = true;
		if("".equals(inputedPhoneNumber) || inputedPhoneNumber == null) {
			isCorrect = false;
		}

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
		if("".equals(inputedName) || inputedName == null) {
			isCorrect = false;
		}

		int len = inputedName.length();
		if (len >= 21) {
			isCorrect = false;
		}

		return isCorrect;
	}

}
