import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
import java.sql.*;

public class EditServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
	{
		int eno=Integer.parseInt(req.getParameter("eno"));
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
	try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/iactdata?user=root&password=");
		
			String qry = "select * from emp where eno=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1,eno);
			ResultSet rs=ps.executeQuery();
			out.println("UPDATE RECORD\n");
			if(rs.next()){
				int eeeno=rs.getInt(1);
				String sn =rs.getString(2);
				int sal =rs.getInt(3);
				String dn = rs.getString(4);
				
				out.println("<form action=updtreco>");
				out.println("Employee no is<input type=text name=eno value="+eeeno+"> ");
				out.println("Employee name is<input type=text name=ename value="+sn+"> ");
				out.println("Employee salary is<input type=text name=sal value="+sal+"> ");
				out.println("Employee department is<input type=text name=dn value="+dn+"> ");
				out.println("<input type=submit value=update />");
				
				out.println("</form>");
				
				
			}
			
			
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}