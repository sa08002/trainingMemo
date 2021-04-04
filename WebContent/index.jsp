<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/javascript; charset=UTF-8">
<title>顧客管理</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <h1>顧客管理</h1>
    <div class="main">
        <h2>新規登録</h2>
        <form name="form1" action="CustomerServlet" method="post"
            onsubmit="return funcConfirm()">
            <table>
                <tr>
                    <td class="title">氏名</td>
                    <td><input type="text" name="customer_name" maxlength="20"></td>
                </tr>
                <tr>
                    <td class="title">郵便番号</td>
                    <td><input type="text" name="zip" maxlength="20"></td>
                </tr>

                <tr>
                    <td class="title">住所１</td>
                    <td><input type="text" name="address1" maxlength="100"></td>
                </tr>
                <tr>
                    <td class="title">住所２</td>
                    <td><input type="text" name="address2" maxlength="100"></td>
                </tr>

                <tr>
                    <td class="title">TEL</td>
                    <td><input type="text" name="tel_number" maxlength="20"></td>
                </tr>

                <tr>
                    <td class="title">FAX</td>
                    <td><input type="text" name="fax_number" maxlength="20"></td>
                </tr>

                <tr>
                    <td class="title">E-mail</td>
                    <td><input type="text" name="mail" maxlength="100"></td>
                </tr>

            </table>
            <p>
                <!--
                <input type="submit" value="送信">
             -->
                <button name="state" value="new_confirm">送信</button>
                <input type="button" value="戻る" onclick="history.back()">
            </p>
        </form>
    </div>
</body>

<script type="text/javascript">
        function funcConfirm() {

            if (document.form1.customer_name.value == "") {
                alert("氏名が入力されていません。");
                return false;
            }
            if (!document.form1.zip.value.match(/^[\x20-\x7E]+$/)) {
                alert("郵便番号は半角英数字と記号で入力してください");
                return false;
            }
            if (document.form1.address1.value == "") {
                alert("住所１が入力されていません。");
                return false;
            }

            if (!document.form1.tel_number.value.match(/^[\x20-\x7E]+$/)) {
                alert("TELは半角英数字と記号で入力してください");
                return false;
            }

            if (!document.form1.mail.value.match(/^[\x20-\x7E]+$/)) {
                alert("E-mailは半角英数字と記号で入力してください");
                return false;
            }
        }
    </script>
</html>
