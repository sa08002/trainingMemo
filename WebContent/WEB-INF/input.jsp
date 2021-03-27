<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>筋トレ一覧</title>
</head>
<body>
<h2>筋トレ一覧</h2>

<form action="/trainingMemo/Main" method="post">
ベンチプレス：<input type="number" name="bench"><br>
デッドリフト：<input type="number" name="deadlift"><br>
スクワット：<input type="number" name="squat"><br>
<input type="submit" value="送信" >
</form>

<a href="/trainingMemo/Main">戻る</a>

</body>
</html>