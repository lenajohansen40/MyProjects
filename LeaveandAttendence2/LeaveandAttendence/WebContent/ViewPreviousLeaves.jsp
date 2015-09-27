<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %> 
<%
String empId=request.getParameter("Emp_id");

try{
	Connection connection = null;
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "hr", "hr"); //change username and password

	Statement statement = connection.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

	ResultSet rs=null;

	statement=connection.createStatement();
	rs=statement.executeQuery("select * from LeavesInfo where status="+"'true'"+"and emp_id="+empId);
	
	while(rs.next())
	{
	%>
		
		// displaying previous leaves in tabular form
		
<table>

<thead>
<tr>
<th>Leave Id</th>
<th>Employee Id</th>
<th>Leave_From</th>
<th>Leave_To</th>
<th>Leave_Status</th>
<th>Leave_Cause</th>
</tr>
</thead>
<tr>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getDate(3) %></td>
<td><%=rs.getDate(4) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getString(6) %></td>
</tr>
</table>
		
		
		
		<%
	}//while loop


	}catch(Exception e)
{
	e.printStackTrace();
}




%>
</body>
</html>