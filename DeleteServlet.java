import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class DeleteServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
	PrintWriter out = res.getWriter();
	res.setContentType("text/html");
	int eno=Integer.parseInt(req.getParameter("eno"));
	
	
	try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/iactdata?user=root&password=");
		
			String qry = "delete from emp where eno=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1,eno);
			int a= ps.executeUpdate();
			
			
			if(a==1)
				res.sendRedirect("displaydata");
			
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}