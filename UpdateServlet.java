//This program will show you how to update the values stored in the database (HeidiSQL) with the help of tomcat server.

import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class UpdateServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		int eno=Integer.parseInt(req.getParameter("eno"));
		String ename=req.getParameter("ename");
		String dname=req.getParameter("dn");
		int salary=Integer.parseInt(req.getParameter("sal"));
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/iactdata?user=root&password=");
		
			String qry = "update emp set ename=?, sal=?, dname=? where eno=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1,ename);
			ps.setInt(2,salary);
			ps.setString(3,dname);
			ps.setInt(4,eno);
			int a=ps.executeUpdate();
			if(a==1){
			res.sendRedirect("displaydata");
			}			
		}
		
		catch(Exception e){
			System.out.println(e);
		}
	}
}
