// This program will demonstrate the adding the record to the database table which have predefined columns as (eno, sn, sal, dn) in the database.


import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddRecordServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
	PrintWriter out = res.getWriter();
	res.setContentType("text/html");
	try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/iactdata?user=root&password=");
			
			int eno = Integer.parseInt(req.getParameter("n1"));

			String sn = req.getParameter("t1");

			int sal = Integer.parseInt(req.getParameter("n2"));
			
			String dn = req.getParameter("t2");

			
			String qry = "insert into emp values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1,eno);
			ps.setString(2,sn);
			ps.setInt(3,sal);
			ps.setString(4,dn);
			int a = ps.executeUpdate();
			if(a==1){
				out.println("Data is recorded");
			}
			else{
				out.println("Data is not recorded");
				
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
