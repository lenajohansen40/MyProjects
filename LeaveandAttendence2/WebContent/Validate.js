/**
 * 
 */

 function validateLoginForm()
  {
  var Name=document.forms["LoginForm"]["user_name"].value;
  var pass=document.forms["LoginForm"]["password"].value;
  if (Name==null || Name=="")
    {
    alert("First name must be filled out");
    return false;
    }
  if (pass==null || pass=="")
  {
  alert("Password must be filled out");
  return false;
  }
 }
 
 function validateApplyLeaveForm() {
	 var from_date=document.forms["applyLeave"]["from_date"].value;
	 var to_date=document.forms["applyLeave"]["to_date"].value;
	 var cause=document.forms["applyLeave"]["cause_of_leave"].value;
	var sysdate=new Date();
	 if(from_date==null||from_date==""){
		 alert("From Date must be filled out");
		//    return false; 
	 }
	 if(to_date==null||to_date==""){
		 alert("To Date must be filled out");
		    return false; 
		 }
	 if(cause==null||cause==""){
		 alert("cause of leave must be filled out");
		    return false; 
		}
	 //sysdate.setFullYear(sysdate.getFullYear(),sysdate.getMonth(),sysdate.getMonth());
	
	//document.write(sysdate);
	//sysdate.setFullYear(sysdate.getFullYear(),sysdate.getMonth(),sysdate.getDate());
	//var sysdate2=new Date(from_date);
	//var date1=sysdate2.getDate();
	//var year1=sysdate2.getFullYear();
	//var month1=sysdate2.getMonth();
	//var date=sysdate.getDate();
	//var year=sysdate.getFullYear();
	//var month=sysdate.getMonth();
	//ocument.write(sysdate2.getDate());
	//document.write(sysdate2.getFullYear());
	//document.write(sysdate2.getMonth())
	//document.write(sysdate.getDate());
	//document.write(sysdate.getFullYear());
	//document.write(sysdate.getMonth());
	//if(year>=year1) {
	//	alert("Invalid Year it must be Greater or Equal to current year");
	//    return false; 
	//}
	//else if(year<=year1){
	//	 if(year==year1&&month1<month){
		//	 alert("Invalid Month it must be Greater or Equal to current Month");
		//	    return false;  
		// }
		// if(year=year1&&month1==month&&date1<date){
		//	 alert("Invalid Date it must be Greater or Equal to current Date");
		//	    return false;   
		// }
	// }
	
     }
 