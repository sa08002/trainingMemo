<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集画面</title>
</head>
<body>
<form name="form1" action="/trainingMemo/Main" method="post" onsubmit="return funcConfirm()">
筋トレ日：<input type="date" name="day" value="${trainingMemo.day}"></input><br>
ベンチプレス：<input type="text" name="bench" value="${trainingMemo.bench}"><br>
デッドリフト：<input type="text" name="deadlift" value="${trainingMemo.deadlift}"><br>
スクワット：<input type="text" name="squat" value="${trainingMemo.squat}"><br>
詳細：<br>
<textarea name="text" rows="5" cols="30">${trainingMemo.text}</textarea><br>
<button name="state" value="editConfirmation,${trainingMemo.id}">送信</button>
</form>

</body>
</html>