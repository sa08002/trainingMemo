<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認</title>
</head>
<body>
<h3>以下の投稿を削除しますか？</h3>
<p>筋トレ日：<c:out value="${trainingMemo.day}" /><br>
ベンチプレス：<c:out value="${trainingMemo.bench}" /><br>
デッドリフト：<c:out value="${trainingMemo.deadlift}" /><br>
スクワット：<c:out value="${trainingMemo.squat}" /></p>
<form action="/trainingMemo/Main" method="post">
	<button name="state" value="deleteExecution,${trainingMemo.id}">はい</button>
	<input type="button" value="戻る" onclick="history.back()">
</form>

</body>
</html>