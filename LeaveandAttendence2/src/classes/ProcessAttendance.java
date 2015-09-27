package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DataBaseConnectivity;

/**
 * Servlet implementation class ProcessAttendance
 */
public class ProcessAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ProcessAttendance() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Connection con=null;
		Statement st,st1=null;
		ResultSet rs,rs1=null;
		int row=0;
		HttpSession hs=request.getSession(false);
		String name=(String)hs.getAttribute("name");
		String id=(String)hs.getAttribute("eid");
		String button=request.getParameter("submit");
		System.out.println("EmployeeId:"+id );
		System.out.println("Button:"+button);
		try{
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//con=DriverManager.getConnection("jdbc:odbc:Mydsn","hr","hr");
			if("In Time".equalsIgnoreCase(button)){
				//st=con.createStatement();
				//rs=st.executeQuery("select to_char(sysdate,'DY') from dual");
			rs=DataBaseConnectivity.selectData("select to_char(sysdate,'DY') from dual");
				//st1=con.createStatement();
				//rs1=st1.executeQuery("select * from LeavesInfo where emp_id='"+id+"' and sysdate between leave_from_date and leave_to_date and status.toUpperCase='APPROVED'");
		    rs1=DataBaseConnectivity.selectData("select * from LeavesInfo where emp_id='"+id+"' and sysdate between leave_from_date and leave_to_date and Upper(status)='APPROVED'");
			if(rs.next()){
			String day=rs.getString(1);
			System.out.println("Day:"+day);
			if("SUN".equalsIgnoreCase(day)||"SAT".equalsIgnoreCase(day)){
			out.print("<br/> Today is a holiday ");
			  }
			
			else if(rs1.next()){
			out.print("<br/> U are on leave today...... ");
				}
			else{
				
				System.out.println("in the Else Block");
				
				System.out.println("<a href='ViewAttendance.jsp'>View Attendence </a>");
				String query="insert into attendance(emp_id,attendance_date,intime) values('"+id+"',sysdate,to_char(sysdate,'hh:mm:ss'))";
					///st1=con.createStatement();
					//row=st1.executeUpdate(query);
					row=DataBaseConnectivity.updateData(query);
					if(row>0)
					{
						out.println("<script>");
						RequestDispatcher rd=request.getRequestDispatcher("ViewAttendance.jsp");
						rd.forward(request, response);
					}
					else
						out.print("<br/> Error encountered....<br/> Try again later");
				}
			}
			}
			else if("Out Time".equalsIgnoreCase(button)){
				//st=con.createStatement();
				String que="select * from attendance where to_char(attendance_date,'DD:MON:YY')=to_char(sysdate,'DD:MON:YY') and emp_id='"+id+"'";
				rs=DataBaseConnectivity.selectData(que);
				System.out.println("In the Out Time Block");
					//st.executeQuery(que);
				if(rs.next()){
					String intime=rs.getString(3);
					System.out.println("In the Out Time Block2");
					if(intime!=null){
						String query="update attendance set outtime=to_char(sysdate,'hh:mm:ss') where to_char(attendance_date,'DD:MON:YY')=to_char(sysdate,'DD:MON:YY')  and emp_id='"+id+"' and outtime is null";
						//st1=con.createStatement();
						row=DataBaseConnectivity.updateData(query);
						System.out.println("In the Out Time Block3");
							//st1.executeUpdate(query);
						System.out.println("updation Performed:"+row);
						if(row>0)
							out.println("Attendance Marked");
						else
							out.print("<br/> Error encountered....<br/> Try again later");
					}
					else{
						out.print("<br/> Please specify the in time first !!!!");
					}
				}				
			}
		}
		catch(Exception e){
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
