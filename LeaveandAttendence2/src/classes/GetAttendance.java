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
		String todate=request.getParameter("demo2");
		String fromdate=request.getParameter("demo1");
		System.out.println("ToDate:"+todate);
		System.out.println("From Date:"+fromdate);
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
			String query="select * from attendance where to_char(attendance_date,'DD-MON-YY') between'"+fromdate+"' and '"+todate+"' and emp_id='"+id+"' order by attendance_date";
			//st=con.createStatement();
			//rs=st.executeQuery(query);
			rs=DataBaseConnectivity.selectData(query);
			while(rs.next()){
				out.print("attendance for :     "+rs.getString(2));
				out.print("In-Time:     "+rs.getString(3));
				out.print("Out-Time:     "+rs.getString(4));
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
