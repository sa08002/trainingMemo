<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>筋トレ記録</title>
</head>
<body>

<a href="/trainingMemo/Input">記録入力画面へ</a>

<c:forEach var="trainingMemo" items="${trainingMemoList}">
	<p>筋トレ日：<c:out value="${trainingMemo.day}" /><br>
	ベンチプレス：<c:out value="${trainingMemo.bench}" /><br>
	デッドリフト：<c:out value="${trainingMemo.deadlift}" /><br>
	スクワット：<c:out value="${trainingMemo.squat}" /></p>
	<form action="/trainingMemo/Main" method="post">
		<button name="state" value="delete_confirm,${trainingMemo.id}">削除</button>
	</form>
</c:forEach>


</body>
</html>