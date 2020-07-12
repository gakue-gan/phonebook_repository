package com.ojtproject.phonebook.service;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.ojtproject.phonebook.dao.PhoneBookRepository;
import com.ojtproject.phonebook.entity.PhoneBookPh2Entity;
import com.ojtproject.phonebook.form.SearchResultForm;
import com.ojtproject.phonebook.util.Prefectures;
import com.ojtproject.phonebook.util.ValidationUtil;

/**
 * 検索クラス
 */
@Service
public class SearchService {
	@Autowired
	private HttpSession session;

	@Autowired
	private PhoneBookRepository phoneBookRepository;

	public void search(String keyword) {

		List<PhoneBookPh2Entity> phoneBookList = null;
		if (!ValidationUtil.validateKeyword(keyword).isEmpty()) {
			// 入力値が不正な場合全件表示
			phoneBookList = phoneBookRepository.findAll();

		} else {
			// キーワード検索
			phoneBookList = phoneBookRepository.find(keyword);
		}
		// セッションにphoneBookListを格納
		session.setAttribute("phoneBookList", phoneBookList);

	}

	public void createPages(int pageNumber, String keyword, ModelAndView mav) {

		List<PhoneBookPh2Entity> phoneBookList = (ArrayList<PhoneBookPh2Entity>) session.getAttribute("phoneBookList");
		List<SearchResultForm> searchList = new ArrayList<>();

		int len = phoneBookList.size();
		for (int i = 15 * (pageNumber - 1); i < Math.min((15 * pageNumber), len); i++) {
			PhoneBookPh2Entity entity = phoneBookList.get(i);
			SearchResultForm sf = new SearchResultForm();
			sf.setId(entity.getId());
			sf.setName(entity.getName());
			sf.setPhoneNumber(entity.getPhoneNumber());
			sf.setAddress(entity.getAddress());
			searchList.add(sf);
		}

		boolean existsNext = len > 15 * pageNumber ? true : false;

		mav.addObject("existsNext", existsNext);
		mav.addObject("searchList", searchList);
		mav.addObject("keyword", keyword);
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName("search");
		searchMsg(searchList, pageNumber, keyword, mav);
	}

	/*
	 * CSV出力メソッド。住所をもとに各都道府県ごとの人数を集計。サマリーをCSVとして出力する。
	 */
	public void writeCSV(ModelAndView mav) {
		Map<String, Integer> writtenMap = new LinkedHashMap<>(); 			// CSVファイルとして出力するMap<都道府県名, 居住人数>
																			// 例：北海道, 23 青森県, 65

		List<PhoneBookPh2Entity> phoneBookList = (ArrayList<PhoneBookPh2Entity>) session.getAttribute("phoneBookList");
																			// セッションに格納した電話帳リスト
		Prefectures[] pf = Prefectures.values(); 							// 「1.北海道, 2.青森県…」といった都道府県Map

		for (Prefectures p : pf) {											// 電話帳リストに該当都道府県の存在する件数をカウント
			String prefecture = p.getFullText();
			int count = 0;
			for (int j = 0, len = phoneBookList.size(); j < len; j++) {
				PhoneBookPh2Entity pb = phoneBookList.get(j);
				if(prefecture.equals(pb.getAddress())) {
					count++;
				}
			}
			writtenMap.put(prefecture, count);
		}

																			//カンマ
		final String COMMA = ",";
																			//改行
		final String NEW_LINE = "\r\n";

		List<String> message = new ArrayList<>();
		try {																// MapをCSVファイルに変換
			String home = System.getProperty("user.home");					// ダウンロード先を各々のダウンロードフォルダに指定
			OutputStream os = new FileOutputStream(home+"\\Downloads\\sample.csv");
			OutputStreamWriter osw = new OutputStreamWriter(os, "Shift_JIS");
																			// CSVファイルの文字コードをShift-JISに変更(エクセル出力のため)
			PrintWriter p = new PrintWriter(new BufferedWriter(osw));

			p.print("都道府県");
			p.print(COMMA);
			p.print("居住人数");
			p.print(NEW_LINE);

																			//リストの内容を順に処理
			for (Map.Entry<String, Integer> writtenData : writtenMap.entrySet()) {
				p.print(writtenData.getKey());
				p.print(COMMA);
				p.print(writtenData.getValue());
				p.print(NEW_LINE);
			}

			p.close();
			System.out.println("CSVファイル出力完了"); 						// 完了すればコンソールに表示
			message.add("CSV出力が成功しました。");							// 画面にも表示

		} catch (Exception e) {
			message.add("CSV出力が失敗しました。");							// 失敗すれば画面に表示
			e.printStackTrace();
		}
		mav.addObject("msg", message);
	}

	private void searchMsg(List<SearchResultForm> searchList, int pageNumber,
			String keyword, ModelAndView mav) {
		List<PhoneBookPh2Entity> phoneBookList = (ArrayList<PhoneBookPh2Entity>) session.getAttribute("phoneBookList");

		List<String> msg = new ArrayList<>();

		List<String> msgList = (List<String>) mav.getModelMap().getAttribute("msg");
		if (msgList != null) {
			msg.addAll(msgList);
		}
		msg.addAll(ValidationUtil.validateKeyword(keyword));
		if (msg.isEmpty()) {
			msg.add(keyword + "を検索します。");
		}

		if (searchList.size() == 0) {
			msg.add(MessageService.SEARCH_NOT_HIT);
		} else {
			msg.add(phoneBookList.size() + MessageService.SEARCH_HIT_COUNT
					+ (searchList.size() + 15 * (pageNumber - 1)) + MessageService.SEARCH_HIT_DISPLAYEDCOUNT);
		}

		mav.addObject("msg", msg);

	}

}