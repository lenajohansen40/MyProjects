<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.*"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<form action="ProcessAttendance">
			<table>
				<tr>
					<td><input type="submit" value="In Time" name="submit"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="Out Time" name="submit"/></td>
				</tr>
			</table>
		</form>
	</body>
</html>