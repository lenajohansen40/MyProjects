package classes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DataBaseConnectivity;

/**
 * Servlet implementation class UserValidate
 */
public class UserValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        try {
	          
	           
	           String username=request.getParameter("user_name");
	          // System.out.println("UserName:"+username);
	           String password=request.getParameter("password");
	         //  System.out.println("Password"+password);
	           String query="select * from employee where emp_id='"+username+"' and password='"+password+"'";
	           ResultSet resultSet=DataBaseConnectivity.selectData(query);
	           //System.out.print("Connection DOne:");
	           
	           if(resultSet.next()){
	               String name=resultSet.getString(2);
	               String designation=resultSet.getString(5);
	                HttpSession hs=request.getSession(true);
	                  hs.setAttribute("eid",username);
	              if(!designation.equals("Admin")){
	                   out.println("<font color=red><h1 align=center>");
	                  out.println("Welcome  "+name);
	                  out.println("</h1></font>");
	                  RequestDispatcher requestDispatcher=request.getRequestDispatcher("WelcomeAdmin.jsp");
	                  requestDispatcher.include(request, response);
	              }
	              if(designation.equals("Admin")){
	                  out.println("<font color=red><h1 align=center>");
	                  out.println("Welcome  "+name);
	                  out.println("</h1></font>");
	                  RequestDispatcher requestDispatcher=request.getRequestDispatcher("Texturedmenu.jsp");
	                  requestDispatcher.include(request, response);
	              }

	           }else
	           {
	               out.println("<font color=red><h1 align=center>");
	                  out.println("EMPLOYEE DOES NOT EXIST!!!!!");
	                  out.println("</h1></font>");
	                 
	           }
	           
	          //response.sendRedirect("index.jsp");
	           
	        }
	         catch(SQLException ex){
	            //Code when the SQL Exception Occur
	            System.out.println("SQL ERROR:"+ex.getMessage());
	             //response.sendRedirect("Error.jsp");
	            }

	        finally {
	            out.close();
	        }
	}

}
