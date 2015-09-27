<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p> 
<%
HttpSession hs=request.getSession(false);
String empId=(String)hs.getAttribute("eid");
String leaveId=request.getParameter("value");
%>

<font color="red" size="5px">Leave Has been Applied</font>
</br>Employee id=<%=empId%>
</br>LeaveApplication id=<%=request.getParameter("value") %>
</br>Status=<%="Pending" %>

</body>
</html>