package com.ojtproject.phonebook.form;

public class UpdateForm {

	private int id;
	private String name;
	private String areaCode;
	private String cityCode;
	private String identificationCode;
	private String addressKey;


	public int getId() {
		return id;
	}

	public String getAddress() {
		return addressKey;
	}

	public void setAddress(String address) {
		this.addressKey = address;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getIdentificationCode() {
		return identificationCode;
	}

	public void setIdentificationCode(String identificationCode) {
		this.identificationCode = identificationCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private String errorMessage;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
