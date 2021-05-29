<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="model.TrainingMemo" %>

<%
TrainingMemo trainingMemo = (TrainingMemo) session.getAttribute("trainingMemo");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集内容確認</title>
</head>
<body>
<h3>以下の内容で編集しますか？</h3>
<p>
筋トレ日：<%= trainingMemo.getDay() %><br>
ベンチプレス：<%= trainingMemo.getBench() %><br>
デッドリフト：<%= trainingMemo.getDeadlift() %><br>
スクワット：<%= trainingMemo.getSquat() %><br>
詳細：<br>
<%= trainingMemo.getText() %>
</p>
<form action="/trainingMemo/Main" method="post">
	<button name="state" value="editExecution,${trainingMemo}">はい</button>
	<input type="button" value="戻る" onclick="history.back()">
</form>
</body>
</html>