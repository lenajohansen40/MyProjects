<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<html>
<head>
  <title>Attendance Viewer</title>
  <link rev="made" href="mailto:contact@rainforestnet.com">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
<script language="javascript" type="text/javascript" src="datetimepicker.js">
</script>

</head>
<body bgcolor="#FFFFFF" text="#000000" link="#0000FF" vlink="#800080" alink="#FF0000">
	<form action="GetAttendance">
		<table width="700" cellspacing=0 border="0" cellpadding="0" align="center" summary="">
	 		<tr>
	  			<td>From Date :</td>
	  			<td>
	  				<input type="Text" id="demo1" name="attendence_from_date" maxlength="25" size="25"><a href="javascript:NewCal('demo1','ddmmmyyyy',false,24)"><img src=Images/cal.jpg width="16" height="16" border="0" alt="Pick a date"></a>
	  			</td>
	 		</tr>
	 		<tr>
	  			<td>To Date :</td>
	  			<td>
	  				<input type="Text" id="demo2" name="attendence_to_date"  maxlength="25" size="25"><a href="javascript:NewCal('demo2','ddmmmyyyy',false,24)"><img src=Images/cal.jpg width="16" height="16" border="0" alt="Pick a date"></a>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>
	  				<br/><br/>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>
	  				<input type="submit" name="submit" value="View Report"/>
	  			</td>
	  		</tr>
	  	</table>
	 </form>
</body>
</html>
