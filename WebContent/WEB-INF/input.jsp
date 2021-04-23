<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入力画面</title>
</head>
<body>
<h2>入力画面</h2>

<form name="form1" action="/trainingMemo/Main" method="post" onsubmit="return funcConfirm()">
筋トレ日：<input type="date" name="day"></input><br>
ベンチプレス：<input type="text" name="bench"><br>
デッドリフト：<input type="text" name="deadlift"><br>
スクワット：<input type="text" name="squat"><br>
<button name="state" value="newConfirm">送信</button>
</form>

<a href="/trainingMemo/Main">戻る</a>

</body>

<script type="text/javascript">
		function funcConfirm() {
			if (document.form1.day.value == "") {
				alert("日付が選択されていません。");
				return false;
			}

			if (document.form1.bench.value == "") {
				alert("ベンチプレスが入力されていません。");
				return false;
			}

			if (document.form1.deadlift.value == "") {
				alert("デッドリフトが入力されていません。");
				return false;
			}

			if (document.form1.squat.value == "") {
				alert("スクワットが入力されていません。");
				return false;
			}

			if (document.form1.bench.value.match(/[^0-9]+/)
				|| document.form1.deadlift.value.match(/[^0-9]+/)
				|| document.form1.squat.value.match(/[^0-9]+/)) {
					alert("半角英数字で入力してください");
					return false;
	 			}
		}
</script>

</html>