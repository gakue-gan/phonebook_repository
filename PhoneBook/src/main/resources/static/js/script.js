function submitChk() {
	/* 確認ダイアログ表示 */
	var flag = window.confirm("処理を実行してよろしいですか？");
	/* send_flg が TRUEなら送信、FALSEなら送信しない */

	return flag;
}



/**
 * //地域と都道府県の一覧
var areaPreList = {
  "00":{
    "01":"北海道",
    "02":"青森県",
    "03":"岩手県",
    "04":"宮城県",
    "05":"秋田県",
    "06":"山形県",
    "07":"福島県",
    "08":"茨木県",
    "09":"栃木県",
    "10":"群馬県",
    "11":"埼玉県",
    "12":"千葉県",
    "13":"東京都",
    "14":"神奈川県",
    "15":"新潟県",
    "16":"富山県",
    "17":"石川県",
    "18":"福井県",
    "19":"山梨県",
    "20":"長野県",
    "21":"岐阜県",
    "22":"静岡県",
    "23":"愛知県",
    "24":"三重県",
    "25":"滋賀県",
    "26":"京都府",
    "27":"大阪府",
    "28":"兵庫県",
    "29":"奈良県",
    "30":"和歌山県",
    "31":"鳥取県",
    "32":"島根県",
    "33":"岡山県",
    "34":"広島県",
    "35":"山口県",
    "36":"徳島県",
    "37":"香川県",
    "38":"愛媛県",
    "39":"高知県",
    "40":"福岡県",
    "41":"佐賀県",
    "42":"長崎県",
    "43":"熊本県",
    "44":"大分県",
    "45":"宮崎県",
    "46":"鹿児島県",
    "47":"沖縄県"},
  "01":{
    "01":"北海道",
    "02":"青森県",
    "03":"岩手県",
    "04":"宮城県",
    "05":"秋田県",
    "06":"山形県",
    "07":"福島県"},
  "02":{
    "08":"茨木県",
    "09":"栃木県",
    "10":"群馬県",
    "11":"埼玉県",
    "12":"千葉県",
    "13":"東京都",
    "14":"神奈川県"},
  "03":{
    "15":"新潟県",
    "16":"富山県",
    "17":"石川県",
    "18":"福井県",
    "19":"山梨県",
    "20":"長野県",
    "21":"岐阜県",
    "22":"静岡県",
    "23":"愛知県",
    "24":"三重県"},
  "04":{
    "25":"滋賀県",
    "26":"京都府",
    "27":"大阪府",
    "28":"兵庫県",
    "29":"奈良県",
    "30":"和歌山県"},
  "05":{
    "31":"鳥取県",
    "32":"島根県",
    "33":"岡山県",
    "34":"広島県",
    "35":"山口県"},
  "06":{
    "36":"徳島県",
    "37":"香川県",
    "38":"愛媛県",
    "39":"高知県"},
  "07":{
    "40":"福岡県",
    "41":"佐賀県",
    "42":"長崎県",
    "43":"熊本県",
    "44":"大分県",
    "45":"宮崎県",
    "46":"鹿児島県",
    "47":"沖縄県"},
  };

  /**

  $(document).ready(function(){

     // 都道府県プルダウン生成
     createPreDownList("00");
     // プルダウンの初期選択
     $("select[name='areaselector']").val("00");
     $("select[name='areaselector']").selectmenu('refresh',true);
     $("select[name='address']").val("00");
     $("select[name='address']").selectmenu('refresh',true);
   });


   	// 都道府県のセレクターの制御

  $("select[name='areaselector']").on('change',function(event){
    var areano = $(this).val();
    // ドロップダウンリストを作成
    createPreDownList(areano);
    // 生成したリストの選択とリフレッシュ（JQueryMobile)
    $("select[name='address']").val("00");
    $("select[name='address']").selectmenu('refresh',true);
  });

  //都道府県のリストを作成して、リストに追加する。

  function createPreDownList(areano) {
    var preList = areaPreList[areano];
    var optItem = "<option value='00'>選択してください</option>";
    // 表示順制御のため、ソート
    var keylist=new Array;
    for(key in preList) keylist.push(key);
    keylist.sort();
    // リスト作成
    for(key in keylist){
      optItem += "<option value='"+ keylist[key] + "'>"+ preList[keylist[key]] + "</option>"
    }
    $("select[name='preselector'] option").remove();
    $("select[name='preselector']").append(optItem);
  }
 */
