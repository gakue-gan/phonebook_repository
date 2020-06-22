function submitChk() {
	/* 確認ダイアログ表示 */
	var flag = window.confirm("処理を実行してよろしいですか？");
	/* send_flg が TRUEなら送信、FALSEなら送信しない */
	if(flag){
		window.alert("正常に処理されました。");
	} else {
		window.alert("処理が中断しました。");
	}
	return flag;
}