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
	out.println("Welcome Admin\n");
%>
<br>	
<%
	out.println("Dispalying the leaves waiting for your approval");
%>
<%-- connecting to database --%>

<%
try{
Connection connection = null;
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl", "hr", "hr"); //change username and password

Statement statement = connection.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

ResultSet rs=null;

statement=connection.createStatement();
rs=statement.executeQuery("select * from LeavesInfo");

while(rs.next())
{
	
	
	%>
<table>

<thead>
<tr>
<th>Leave Id</th>
<th>Employee Id</th>
<th>Leave_From</th>
<th>Leave_To</th>
<th>Leave_Status</th>
<th>Leave_Cause</th>
<th>Approve</th>
<th>DisApprove</th>
<th>Leave_History</th>
</tr>
</thead>

<tr>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getDate(3) %></td>
<td><%=rs.getDate(4) %></td>
<td><%=rs.getString(5) %></td>
<td><%=rs.getString(6) %></td>

<%
	String LeaveId=rs.getString(1);
	String EmployeeId=rs.getString(2);
    String Appstr=response.encodeURL("Approve?Leave_id="+LeaveId+"&Emp_id="+EmployeeId);
    String DisAppstr=response.encodeURL("DisApprove?Leave_id="+LeaveId+"&Emp_id="+EmployeeId);
	String PreviousLeaves=response.encodeURL("ViewPreviousLeaves.jsp?Emp_id="+EmployeeId);

%>
<td><a href="<%=Appstr%>">Approve</a></td>
<td><a href="<%=DisAppstr%>">DisApprove</a></td>
<td><a href="<%=PreviousLeaves%>">Leave_History</a></td>
</tr>



</table>
	
	
<%
}//while loop
	
}catch(Exception e){}

%>
	
</body>
</html>