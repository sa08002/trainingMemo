<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿詳細</title>
</head>
<body>
<h3>投稿詳細</h3>
<p>筋トレ日：<c:out value="${trainingMemo.day}" /><br>
ベンチプレス：<c:out value="${trainingMemo.bench}" /><br>
デッドリフト：<c:out value="${trainingMemo.deadlift}" /><br>
スクワット：<c:out value="${trainingMemo.squat}" /><br>
詳細：<br>
<c:out value="${trainingMemo.text}" /></p>
<form action="/trainingMemo/Main" method="post">
	<button name="state" value="edit,${trainingMemo.id}">編集</button>
	<input type="button" value="戻る" onclick="history.back()">
</form>
</body>
</html>