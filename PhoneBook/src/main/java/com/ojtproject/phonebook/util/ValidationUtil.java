package com.ojtproject.phonebook.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
			default :
				return message;
			}

			if (phoneCode == null || "".equals(phoneCode)) {
				message.add(str + "が未入力です。"); 						// 未入力時の処理
				continue;
			}

			if (phoneCode.contains(" ") || phoneCode.contains("　")) {
				message.add(str + "に空白を入力しないでください。");
				continue;
			}

			int length = phoneCode.length();
			if (length <= 1 || 5 <= length) {
				message.add(str + "は2～4文字で入力してください。");
				continue;
			}

			String regex_num = "^[0-9]*$";
			Pattern p = Pattern.compile(regex_num);
			Matcher m = p.matcher(phoneCode);
			if(!m.matches()) {
				message.add(str + "には半角数字以外を入力しないでください");
				continue;
			}

		}
		return message;
	}

	// 電話番号の全体の文字数が10～11文字のみであるかどうかの入力チェック処理
	public static List<String> validateTotalBoxes(String... inputedPhoneNumber) {

		List<String> message = new ArrayList<>();
		for (String v : inputedPhoneNumber) {
			if (v == null)
				return message;
		}

		String phoneNumber = ""; 											// 引数すべてを文字列結合し電話番号を作成
		for (String v : inputedPhoneNumber)
			phoneNumber += v;

		int len = phoneNumber.length();
		if (len <= 9 || 12 <= len)
			message.add("電話番号は10,11文字で入力してください。");

		return message;
	}

	// 名前のボックス一つ分に文字数が20文字以内であるかどうかの入力チェック処理
	public static List<String> validateName(String inputedName) {

		List<String> message = new ArrayList<>();

		if (inputedName == null || "".equals(inputedName)) {				 // 未入力時の処理
			message.add("名前が未入力です。");
			return message;
		}

		int len = inputedName.length(); 									// 20文字以上、空白があるときの処理
		if (len >= 21)
			message.add("名前は20文字以内で入力してください。");

		if (inputedName.contains(" ") || inputedName.contains("　"))
			message.add("名前に空白を入力しないでください。");

		Pattern p = Pattern.compile("^[!\"#$%&'()*+,-./:;<=>?@[¥]^_`{|}~！”＃＄％＆’（）＊＋，ー．／：；＜＝＞？＠［¥］＾＿‘｛｜｝～]*$");
		Matcher m = p.matcher(inputedName);
		if(m.matches())
			message.add("名前に入力できない記号があります。");

		return message;
	}

	// アドレス入力チェック処理
	public static List<String> validateAddress(String address) {
		List<String> message = new ArrayList<>();
		if (address == null || "".equals(address)) {
			message.add("居住都道府県を選択してください。");
		}
		return message;
	}

	// 検索欄の入力チェック処理
	public static List<String> validateKeyword(String keyword) {

		List<String> message = new ArrayList<>();

		if (keyword == null) { 												// nullの時
			message.add("全件を表示します。");
			return message;
		}
		int len = keyword.length(); 										// nullではない時

		if (len >= 21)
			message.add("検索欄は20文字以内で入力してください。");

		if (keyword.contains(" ") || keyword.contains("　"))
			message.add("検索欄に空白を入力しないでください。");

		Pattern p = Pattern.compile("^[!\"#$%&'()*+,-./:;<=>?@[¥]^_`{|}~！”＃＄％＆’（）＊＋，ー．／：；＜＝＞？＠［¥］＾＿‘｛｜｝～]*$");
		Matcher m = p.matcher(keyword);
		if(m.matches() && !"".equals(keyword) ) {
			message.add("検索欄に入力できない記号があります。");
		}

		if(len == 0 || len >= 21 || keyword.contains(" ") || keyword.contains("　")|| m.matches())
			message.add("全件を表示します。");

		return message;
	}


}
