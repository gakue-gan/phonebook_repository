package com.ojtproject.phonebook.util;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtil {
	// 電話番号のボックス一つ分に数字3～4文字のみであるかどうかの入力チェック処理
	public static List<String> validateOneBox(String... inputedPhoneNumber) {

		List<String> message = new ArrayList<>(); 							// メッセージリスト(空であるときに処理実行)
		for (int i = 0, len = inputedPhoneNumber.length; i < len; i++) { 	// 引数の個数分処理を繰り返す。
			String phoneCode = inputedPhoneNumber[i];
			String str = "";
			switch (i) {
			case 0:
				str = "市外局番"; 											// 第一引数を市外局番
				break;
			case 1:
				str = "市内局番"; 											// 第二引数を市内局番
				break;
			case 2:
				str = "認識番号"; 											// 第三引数を認識番号と設定
				break;
			}

			if (phoneCode == null || "".equals(phoneCode)) {
				message.add(str + "が未入力です。"); 						// 未入力時の処理
			} else {
				try { 														// 型変換(String→long)できるかどうか判定
					Long.parseLong(phoneCode);
					int length = phoneCode.length();
					if (length <= 2 || 5 <= length) {
						message.add(str + "は3，4文字で入力してください。");
					}
					if (phoneCode.contains(" ") || phoneCode.contains("　")) {
						message.add(str + "に空白を入力しないでください。");
					}
				} catch (NumberFormatException e) { 						// 文字が入力されているときの処理
					message.add(str + "に文字を入力しないでください。");
				}
			}
		}
		return message;
	}

	// 電話番号の全体の文字数が10～11文字のみであるかどうかの入力チェック処理
	public static List<String> validateTotalBoxes(String... inputedPhoneNumber) {
		String phoneNumber = ""; 											// 引数すべてを文字列結合し電話番号を作成
		for (String v : inputedPhoneNumber) {
			phoneNumber += v;
		}

		List<String> message = new ArrayList<>();

		int len = phoneNumber.length();
		if (len <= 9 || 12 <= len)
			message.add("電話番号は10,11文字で入力してください。");

		return message;
	}

	// 名前のボックス一つ分に文字数が20文字以内であるかどうかの入力チェック処理
	public static List<String> validateName(String inputedName) {

		List<String> message = new ArrayList<>();

		if (inputedName == null || "".equals(inputedName)) {				// 	未入力時の処理
			message.add("名前が未入力です。");
		} else {
			int len = inputedName.length();									// 20文字以上、空白があるときの処理
			if (len >= 21)
				message.add("名前は20文字以内で入力してください。");

			if (inputedName.contains(" ") || inputedName.contains("　"))
				message.add("名前に空白を入力しないでください。");
		}

		return message;
	}

	// 検索欄の入力チェック処理
	public static List<String> validateKeyword(String keyword) {

		List<String> message = new ArrayList<>();

		if (keyword == null) {												// nullの時
			message.add("全件を表示します。");
		} else {
			int len = keyword.length();										// nullではない時
			if (len == 0) {
				message.add("全件を表示します。");
			}
			if (len >= 21) {
				message.add("検索欄は20文字以内で入力してください。");
				message.add("全件を表示します。");
			}
			if (keyword.contains(" ") || keyword.contains("　")) {
				message.add("検索欄に空白を入力しないでください。");
				message.add("全件を表示します。");
			}
		}

		return message;
	}

}
