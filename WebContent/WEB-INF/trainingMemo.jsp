<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.TrainingMemo,java.util.List" %>
<%

List<TrainingMemo> trainingMemoList =
	(List<TrainingMemo>) application.getAttribute("trainingMemoList");

%>
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

<% for(TrainingMemo trainingMemo : trainingMemoList) { %>
<p>
ベンチプレス：<%= trainingMemo.getBench() %><br>
デッドリフト：<%= trainingMemo.getDeadlift() %><br>
スクワット：<%= trainingMemo.getSquat() %></p><br>
<% } %>

</form>
</body>
</html>