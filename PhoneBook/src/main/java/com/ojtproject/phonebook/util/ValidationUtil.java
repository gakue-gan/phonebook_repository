package com.ojtproject.phonebook.util;

public class ValidationUtil {
	// 電話番号のボックス一つ分に文字数が3～4文字のみであるかどうかの入力チェック処理
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
	// 電話番号の全体の文字数が10～11文字のみであるかどうかの入力チェック処理
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
	// 名前のボックス一つ分に文字数が20文字以内であるかどうかの入力チェック処理
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
