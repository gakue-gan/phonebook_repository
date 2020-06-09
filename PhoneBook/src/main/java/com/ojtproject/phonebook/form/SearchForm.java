package com.ojtproject.phonebook.form;

public class SearchForm {
	/**検索キーワード*/
	private String keyword;
	private String ErrorMessage;

	public String getErrorMessage() {
		return ErrorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


}
