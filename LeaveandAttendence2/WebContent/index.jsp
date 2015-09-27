<%-- 
    Document   : index
    Created on : Sep 11, 2012, 8:16:35 PM
    Author     : ashish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<script type="text/javascript" src="Validate.js"></script>
<body>
<form action="GoHomePage" method="post" name="LoginForm" onsubmit="return validateLoginForm()">
<table width="100%" align="center">
<tr> <td>EMPLOYEE ID</td><td><input type="text" name="user_name"></td></tr>
<tr><td>PASSWORD</td><td><input type="password" name="password"></td></tr>
<tr><td><input type="submit" value="submit"></td><td></td></tr>
</table>
</form>
</body>  
</html>
