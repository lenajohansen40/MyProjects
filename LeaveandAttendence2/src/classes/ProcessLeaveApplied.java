package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DataBaseConnectivity;

/**
 * Servlet implementation class ProcessLeaveApplied
 */
public class ProcessLeaveApplied extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessLeaveApplied() {
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
		String fromDate=request.getParameter("from_date");
		String toDate=request.getParameter("to_date");
		System.out.println("TO_date:"+toDate);
		System.out.println("From_date:"+fromDate);
		String causeOfLeave=request.getParameter("cause_of_leave");
		Date fromDateObj=new Date(fromDate);
		Date toDateObj=new Date(toDate);
		
		int leavePeriod=(int)(toDateObj.getTime() - fromDateObj.getTime()) / (1000 * 60 * 60 * 24);
			
		//toDateObj.compareTo(fromDateObj);
		int remLeaves=0;
		System.out.println("Days:"+leavePeriod);
		//
		HttpSession hs=request.getSession(false);
		
		String empId=(String)hs.getAttribute("eid");
		String query1="Select REM_LEAVES From Employee Where Emp_id='"+empId+"'";
		ResultSet rs=DataBaseConnectivity.selectData(query1);
		try {
			if(rs.next())
			{
				remLeaves=rs.getInt(1);	
				System.out.println("Leaves:"+remLeaves);
				
			}
		}
		catch (SQLException e) {
			response.sendRedirect("Error.jsp");
		}
		
		// to check that Employee has the leaves Remaining
		if(remLeaves>=leavePeriod){
			String getLeaveIdQuery="Select Leave_application_id.NEXTVAL from Dual";
			ResultSet rs1=DataBaseConnectivity.selectData(getLeaveIdQuery);
			try {
			if(rs1.next()){
			int leaveId = rs1.getInt(1);
			System.out.println("After LeaveID Generation:");
			String leaveApplicationId="LA"+leaveId;
			System.out.println("Leave Id:"+leaveId);
			String query2="Insert into LeavesInfo(leave_id,emp_id,leave_from_date,leave_to_date,status,cause_of_leave )VALUES('"+leaveApplicationId+"','"+empId+"',to_date('"+fromDate+"','DD-MON-YYYY'),to_date('"+toDate+"','DD-MON-YYYY'),'Pending','"+causeOfLeave+"')";
			System.out.print(query2);
			int leaveAppliedStatus=DataBaseConnectivity.updateData(query2);
			if(leaveAppliedStatus>0){
				//RequestDispatcher rd=request.getRequestDispatcher();
				response.sendRedirect("showLeaveApplication.jsp?value="+leaveApplicationId+"");
				//out.print("");
				//out.print("Your Leaveid is: "+leaveApplicationId);
			}
			} 
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		else{
			response.sendRedirect("ApplicationError.jsp?id1=lessLeaveReamining");
		}
		
	 }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
