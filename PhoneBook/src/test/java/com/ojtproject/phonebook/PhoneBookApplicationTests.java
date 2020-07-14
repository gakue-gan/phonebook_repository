package com.ojtproject.phonebook;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ojtproject.phonebook.util.ValidationUtil;

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

		String name = null;
		List<String> isCorrect = ValidationUtil.validateName(name);
		String msg = "名前が未入力です。";
		assertThat(isCorrect.get(0), is(msg));

		name = "";
		isCorrect = ValidationUtil.validateName(name);
		msg = "名前が未入力です。";
		assertThat(isCorrect.get(0), is(msg));

		name = "123456789012345678901";
		isCorrect = ValidationUtil.validateName(name);
		msg = "名前は20文字以内で入力してください。";
		assertThat(isCorrect.get(0), is(msg));

		name = " ";
		isCorrect = ValidationUtil.validateName(name);
		msg = "名前に空白を入力しないでください。";
		assertThat(isCorrect.get(0), is(msg));

		name = "　";
		isCorrect = ValidationUtil.validateName(name);
		msg = "名前に空白を入力しないでください。";
		assertThat(isCorrect.get(0), is(msg));

		name = "あいうえお";
		isCorrect = ValidationUtil.validateName(name);
		assertThat(isCorrect.isEmpty(), is(true));

		name = "12345678901234567890";
		isCorrect = ValidationUtil.validateName(name);
		assertThat(isCorrect.isEmpty(), is(true));

		name = "$$$";
		isCorrect = ValidationUtil.validateName(name);
		msg = "名前に入力できない記号があります。";
		assertThat(isCorrect.get(0), is(msg));

	}

	@Test
	public void validateOneBoxTest() {

		String firstBox = "";
		String secondBox = "1111";
		String thirdBox = "1111";
		List<String> isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		String msg = "市外局番が未入力です。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "市内局番が未入力です。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "1111";
		thirdBox = "";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "認識番号が未入力です。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "1111";
		thirdBox = "1111";
		String forthBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox, forthBox);
		assertThat(isCorrect.isEmpty(), is(true));

		firstBox = "aaaa";
		secondBox = "1111";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "市外局番に半角数字以外を入力しないでください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "aaaa";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "市内局番に半角数字以外を入力しないでください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "1111";
		thirdBox = "aaaa";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "認識番号に半角数字以外を入力しないでください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "11 1";
		secondBox = "1111";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "市外局番に空白を入力しないでください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "11 1";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "市内局番に空白を入力しないでください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "1111";
		thirdBox = "11 1";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "認識番号に空白を入力しないでください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "11　1";
		secondBox = "1111";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "市外局番に空白を入力しないでください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "11　1";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "市内局番に空白を入力しないでください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "1111";
		thirdBox = "11　1";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "認識番号に空白を入力しないでください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = null;
		secondBox = "1111";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "市外局番が未入力です。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = null;
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "市内局番が未入力です。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "1111";
		thirdBox = null;
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "認識番号が未入力です。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1";
		secondBox = "1111";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "市外局番は2～4文字で入力してください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "1";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "市内局番は2～4文字で入力してください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "1111";
		thirdBox = "1";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "認識番号は2～4文字で入力してください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "11111";
		secondBox = "1111";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "市外局番は2～4文字で入力してください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "11111";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "市内局番は2～4文字で入力してください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "1111";
		thirdBox = "11111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		msg = "認識番号は2～4文字で入力してください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "1111";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateOneBox(firstBox, secondBox, thirdBox);
		assertThat(isCorrect.isEmpty(), is(true));

	}

	@Test
	public void validateTotalBoxesTest() {

		String firstBox = "";
		String secondBox = "";
		String thirdBox = "";
		List<String> isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		String msg = "電話番号は10,11文字で入力してください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "111";
		secondBox = "111";
		thirdBox = "111";
		isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		msg = "電話番号は10,11文字で入力してください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = "1111";
		secondBox = "1111";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		msg = "電話番号は10,11文字で入力してください。";
		assertThat(isCorrect.get(0), is(msg));

		firstBox = null;
		secondBox = "11111";
		thirdBox = "11111";
		isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		assertThat(isCorrect.isEmpty(), is(true));

		firstBox = "111";
		secondBox = "1111";
		thirdBox = "1111";
		isCorrect = ValidationUtil.validateTotalBoxes(firstBox, secondBox ,thirdBox);
		assertThat(isCorrect.isEmpty(), is(true));

	}

	@Test
	public void validateKeywordTest() {
		String keyword = null;
		List<String> isCorrect = ValidationUtil.validateKeyword(keyword);
		String msg = "全件を表示します。";
		assertThat(isCorrect.get(0), is(msg));

		keyword = "";
		isCorrect = ValidationUtil.validateKeyword(keyword);
		msg = "全件を表示します。";
		assertThat(isCorrect.get(0), is(msg));

		keyword = "123456789012345678901";
		isCorrect = ValidationUtil.validateKeyword(keyword);
		msg = "検索欄は20文字以内で入力してください。";
		assertThat(isCorrect.get(0), is(msg));
		msg = "全件を表示します。";
		assertThat(isCorrect.get(1), is(msg));

		keyword = " ";
		isCorrect = ValidationUtil.validateKeyword(keyword);
		msg = "検索欄に空白を入力しないでください。";
		assertThat(isCorrect.get(0), is(msg));
		msg = "全件を表示します。";
		assertThat(isCorrect.get(1), is(msg));

		keyword = "　";
		isCorrect = ValidationUtil.validateKeyword(keyword);
		msg = "検索欄に空白を入力しないでください。";
		assertThat(isCorrect.get(0), is(msg));
		msg = "全件を表示します。";
		assertThat(isCorrect.get(1), is(msg));

		keyword = "＄";
		isCorrect = ValidationUtil.validateKeyword(keyword);
		msg = "検索欄に入力できない記号があります。";
		assertThat(isCorrect.get(0), is(msg));
		msg = "全件を表示します。";
		assertThat(isCorrect.get(1), is(msg));

		keyword = "あいうえお";
		isCorrect = ValidationUtil.validateKeyword(keyword);
		assertThat(isCorrect.isEmpty(), is(true));
	}

	@Test
	public void validateAddressTest() {
		String address = "茨城県";
		List<String> isCorrect = ValidationUtil.validateAddress(address);
		assertThat(isCorrect.isEmpty(), is(true));

		address = "";
		isCorrect = ValidationUtil.validateAddress(address);
		String msg = "居住都道府県を選択してください。";
		assertThat (isCorrect.get(0), is(msg));

		address = null;
		isCorrect = ValidationUtil.validateAddress(address);
		msg = "居住都道府県を選択してください。";
		assertThat (isCorrect.get(0), is(msg));
	}

	@Test
	public void validationUtilTest() {
		ValidationUtil vu = new ValidationUtil();
		assertThat(vu, is(vu));
	}

}
