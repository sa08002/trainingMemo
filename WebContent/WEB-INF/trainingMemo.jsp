<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import="model.TrainingMemo,java.util.List" %>
<%

List<TrainingMemo> trainingMemoList =
	(List<TrainingMemo>) application.getAttribute("trainingMemoList");

%> --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>筋トレ記録</title>
</head>
<body>
<form action="/trainingMemo/Main" method="post">
ベンチプレス：<input type="number" name="bench"><br>
デッドリフト：<input type="number" name="deadlift"><br>
スクワット：<input type="number" name="squat"><br>
<input type="submit" value="送信">
</form>

<c:forEach var="trainingMemo" items="${trainingMemoList}">
	<p>ベンチプレス：<c:out value="${trainingMemo.bench}" /><br>
	デッドリフト：<c:out value="${trainingMemo.deadlift}" /><br>
	スクワット：<c:out value="${trainingMemo.squat}" /></p>
</c:forEach>

</body>
</html>