package com.ojtproject.phonebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PhoneBookApplicationTests {

	@BeforeEach
	public void setUp() {

	}

	@Test
	void contextLoads() {

	}

	@Test
	public void validateNameTest() {
		/*
		String name = "";
		boolean isCorrect = ValidationUtil.validateName(name);
		assertThat(isCorrect, is(false));

		name = null;
		isCorrect = ValidationUtil.validateName(name);
		assertThat(isCorrect, is(false));

		name = "藤井";
		isCorrect = ValidationUtil.validateName(name);
		assertThat(isCorrect, is(true));

		name = "12345678901234567890";
		isCorrect = ValidationUtil.validateName(name);
		assertThat(isCorrect, is(true));

		name = "1234567890123456789";
		isCorrect = ValidationUtil.validateName(name);
		assertThat(isCorrect, is(true));

		name = "123456789012345678901";
		isCorrect = ValidationUtil.validateName(name);
		assertThat(isCorrect, is(false));

		name = " 藤井";
		isCorrect = ValidationUtil.validateName(name);
		assertThat(isCorrect, is(false));
		*/

	}

	@Test
	public void validateOneBoxTest() {
		/*
		String firstBox = "";
		boolean isCorrect = ValidationUtil.validateOneBox(firstBox);
		assertThat(isCorrect, is(false));

		firstBox = null;
		isCorrect = ValidationUtil.validateOneBox(firstBox);
		assertThat(isCorrect, is(false));

		firstBox = "012";
		isCorrect = ValidationUtil.validateOneBox(firstBox);
		assertThat(isCorrect, is(true));

		firstBox = "01";
		isCorrect = ValidationUtil.validateOneBox(firstBox);
		assertThat(isCorrect, is(false));

		firstBox = "0123";
		isCorrect = ValidationUtil.validateOneBox(firstBox);
		assertThat(isCorrect, is(true));

		firstBox = "01234";
		isCorrect = ValidationUtil.validateOneBox(firstBox);
		assertThat(isCorrect, is(false));

		firstBox = "藤井";
		isCorrect = ValidationUtil.validateOneBox(firstBox);
		assertThat(isCorrect, is(false));

		firstBox = "０１２３";
		isCorrect = ValidationUtil.validateOneBox(firstBox);
		assertThat(isCorrect, is(true));

		firstBox = "3 4";
		isCorrect = ValidationUtil.validateOneBox(firstBox);
		assertThat(isCorrect, is(false));

		firstBox = "2　3";
		isCorrect = ValidationUtil.validateOneBox(firstBox);
		assertThat(isCorrect, is(false));

		firstBox = "012";
		String secondBox = "0123";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox);
		assertThat(isCorrect, is(true));

		firstBox = "012";
		secondBox = "01235";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox);
		assertThat(isCorrect, is(false));

		firstBox = "012";
		secondBox = "aaaa";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox);
		assertThat(isCorrect, is(false));
		*/
	}

	@Test
	public void validateTotalBoxesTest() {
		/*
		String firstBox = "";
		String secondBox = "";
		String thirdBox = "";
		boolean isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		assertThat(isCorrect, is(false));

		firstBox = "111";
		secondBox = "111";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		assertThat(isCorrect, is(true));

		firstBox = null;
		secondBox = null;
		thirdBox = null;
		isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		assertThat(isCorrect, is(false));

		firstBox = "111";
		secondBox = "1114";
		thirdBox = "1114";
		isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		assertThat(isCorrect, is(true));

		firstBox = "1111";
		secondBox = "1114";
		thirdBox = "1114";
		isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		assertThat(isCorrect, is(false));

		firstBox = "111";
		secondBox = "111";
		thirdBox = "111";
		isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		assertThat(isCorrect, is(false));

		firstBox = "aaaa";
		secondBox = "111";
		thirdBox = "111";
		isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		assertThat(isCorrect, is(false));

		firstBox = " ";
		secondBox = "111";
		thirdBox = "11111";
		isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		assertThat(isCorrect, is(false));

		firstBox = null;
		secondBox ="11111";
		thirdBox = "11111";
		isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		assertThat(isCorrect, is(false));

		firstBox = "111 ";
		secondBox ="1111";
		thirdBox = "111";
		isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		assertThat(isCorrect, is(false));

		 */

	}

}
