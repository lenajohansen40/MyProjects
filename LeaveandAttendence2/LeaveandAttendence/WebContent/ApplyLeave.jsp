<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="javascript" type="text/javascript" src="datetimepicker.js">
</script>
<script language="javascript" type="text/javascript" src="Validate.js">
</script>
</head>
<body>
<table  align="center">
<form action="Leave" name="applyLeave" action="post" onsubmit="return validateApplyLeaveForm()">
<tr> <td colspan="2" align="Center">Apply Leave</td></tr>
<tr><td>From Date</td><td><input type="text" id="demo1" name="from_date"><a href="javascript:NewCal('demo1','ddmmmyyyy',false,24)"><img src=Images/cal.jpg width="16" height="16" border="0" alt="Pick a date"></a></td></tr>
<tr><td>To Date</td><td><input type="Text" id="demo2" maxlength="25" size="25" name="to_date"><a href="javascript:NewCal('demo2','ddmmmyyyy',false,24)"><img src=Images/cal.jpg width="16" height="16" border="0" alt="Pick a date"></a></td></tr>
<tr><td>Cause of Leave</td><td><textarea rows="7" cols="20" name="cause_of_leave"></textarea></td></tr>
<tr><td><input type="submit" name="applyLeave" value="Apply">
</form>

</table>
</body>
</html>