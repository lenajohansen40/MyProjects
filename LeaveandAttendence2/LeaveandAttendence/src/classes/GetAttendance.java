package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import database.DataBaseConnectivity;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GetAttendance
 */
public class GetAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAttendance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String toDate=request.getParameter("attendence_to_date");
		String fromDate=request.getParameter("attendence_from_date");
	    
		
		/*if(Integer.parseInt(toDate.substring(1, 1))<=9){
			toDate="0"+toDate;
		System.out.println("toDate:"+toDate);
		}
		if(Integer.parseInt(fromDate.substring(1, 1))<=9){
			fromDate="0"+fromDate;
		}*/
		System.out.println("ToDate:"+toDate);
		System.out.println("From Date:"+fromDate);
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		HttpSession hs=request.getSession(false);
		String name=(String)hs.getAttribute("name");
		String id=(String)hs.getAttribute("eid");
		out.print("Hello " +name);
		try{
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//con=DriverManager.getConnection("jdbc:odbc:Mydsn","hr","hr");
			//con=DataBaseConnectivity.
			//select * from attendance where lower(to_char(attendance_date,'DD-MON-YY') ) between '02-oct-12' and '02-oct-12' and emp_id='1' order by attendance_date
			String query="select to_char(attendance_date,'DD-MON-YY'),intime,outtime from attendance where to_date(attendance_date,'DD-MON-YY') between to_date('"+fromDate+"','DD-MON-YY') and to_date('"+toDate+"','DD-MON-YY') and emp_id='"+id+"' order by attendance_date";
			//st=con.createStatement();
			//rs=st.executeQuery(query);
			rs=DataBaseConnectivity.selectData(query);
			out.println("<table bgcolor='gray' border='1' align='center'><tr><th><font color='Black'>Date</font></th><th><font color='Black'>IN TIME</font></th><th><font color='Black'>OUT TIME</font></th><tr>");
			out.println("<tr>");
			while(rs.next()){
				String inTime=rs.getString(2);
				String outTime=rs.getString(3);
				out.print("<td><font color='Blue'>"+rs.getString(1)+"</td>");
				if(inTime!=null){
				out.print("<td><font color='Blue'>"+inTime+"</td>");
				}
				else{
					out.print("<td><font color='Blue'>--</td>"); 
					}
				if(outTime!=null){
					out.print("<td><font color='Blue'>"+outTime+"</td>");
					}
				else{
			        out.print("<td><font color='Blue'>--</td>");
				    }
				out.println("</tr>");
			}
			
	}catch(Exception e){
		out.println(e.toString());
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
