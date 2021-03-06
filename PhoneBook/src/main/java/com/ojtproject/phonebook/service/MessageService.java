package com.ojtproject.phonebook.service;

/**対応したメッセージを定義したクラス*/
public class MessageService {
	/**入力したパスワードが空の際に出すメッセージ*/
	public static final String LOGIN_EMPTY = "名前、もしくはパスワードを入力してください。";

	/**ログインに失敗した際に出すメッセージ*/
	public static final String LOGIN_FAILURE = "ログインに失敗しました。";

	/**ログインに失敗した際に出すメッセージ*/
	public static final String LOGIN_SUCCESS = "ログインに成功しました。";

	/**保存成功の際に出すメッセージ*/
	public static final String SAVE_SUCCESS = "保存に成功しました。";

	/**検索ワードが空の際に出すメッセージ*/
	public static final String SEARCH_EMPTY = "検索する名前を入力してください。";

	/**検索にヒットした際に出すメッセージ*/
	public static final String SEARCH_HIT_COUNT = "件中";

	public static final String SEARCH_HIT_DISPLAYEDCOUNT = "件目までを表示";

	/**検索にヒットした際に出すメッセージ*/
	public static final String SEARCH_NOT_HIT = "該当データはありません。";

	/**入力した値が空の場合に出すメッセージ*/
	public static final String INPUT_EMPTY = "名前または電話番号を入力してください。";

	/**入力された名前が20文字以上だった場合に出すメッセージ*/
	public static final String SEARCH_LIMIT = "検索内容は20文字以内で入力してください。";

	/**入力された名前が15文字以上だった場合に出すメッセージ*/
	public static final String NAME_LIMIT = "名前は20文字以内で入力してください。";

	/**新規登録時に表示するメッセージ*/
	public static final String REGIST_NEW = "新規登録をします。";

	/**入力された電話番号が不正な場合に出すメッセージ*/
	public static final String PHONENUMBER_FAULT = "電話番号が不正です。";

	/**入力された電話番号が重複している場合に出すメッセージ*/
	public static final String PHONENUMBER_DOUBLE = "電話番号が重複しています。";

	/**名前とパスワードが入力されていない場合に出すメッセージ*/
	public static final String INPUT_ACCOUNT_EMPTY = "名前またはパスワードを入力されていません。";

	/**入力された名前とパスワードがすでに使われている場合に出すメッセージ*/
	public static final String INPUT_ACCOUNT_USED = "入力された名前とパスワードの組み合わせはすでに使われています。";

	/**アカウント変更を行う際のメッセージ*/
	public static final String EDIT_ACCOUNT = "さんの情報を更新します。";

	/**アカウント変更を行った際のメッセージ*/
	public static final String EDIT_SUCCESS = "さんの情報を更新しました。";

	/**アカウント登録や変更が正常に行われた際に出すメッセージ*/
	public static final String SUCCESS_ACCOUNT = "さんを登録しました。";

	/**アカウント削除が正常に行われた際に出すメッセージ*/
	public static final String DELETE_ACCOUNT = "アカウントを削除しました。";

	/**電話番号を削除した際に出すメッセージ*/
	public static final String DELETE = "さんを削除しました。";

}
