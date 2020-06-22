package com.ojtproject.phonebook.util;

public class ValidationUtil {
	// 電話番号のボックス一つ分に文字数が3～4文字のみであるかどうかの入力チェック処理
	public static boolean validateOneBox(String... inputedPhoneNumber) {

		boolean isCorrect = true;

		for (String v : inputedPhoneNumber) {
			if ("".equals(v) || v == null) {
				isCorrect = false;
			}
			try {
				Long.parseLong(v);
				int len = v.length();
				if (len <= 2 || 5 <= len) {
					isCorrect = false;
				}

			} catch (NumberFormatException e) {
				isCorrect = false;
			}
		}

		return isCorrect;
	}

	// 電話番号の全体の文字数が10～11文字のみであるかどうかの入力チェック処理
	public static boolean validateTotalBoxes(String... inputedNumber) {
		String phoneNumber = "";
		for (String v : inputedNumber) {
			phoneNumber += v;
		}
		boolean isCorrect = true;
		if ("".equals(phoneNumber) || phoneNumber == null) {
			isCorrect = false;
		}

		try {
			Long.parseLong(phoneNumber);
			int len = phoneNumber.length();
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
		if ("".equals(inputedName) || inputedName == null) {
			isCorrect = false;
		}

		int len = inputedName.length();
		if (len >= 21) {
			isCorrect = false;
		}

		return isCorrect;
	}

	public static boolean validateKeyword(String keyword) {
		boolean isCorrect = true;

		int len = keyword.length();
		if (len >= 21) {
			isCorrect = false;
		}

		return isCorrect;
	}

}
