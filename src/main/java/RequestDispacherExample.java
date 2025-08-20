import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RequestDispacherExample")
public class RequestDispacherExample  extends HttpServlet{
		@Override
		protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
			 
			 String myEmail = arg0.getParameter("email");
			 String myPassword = arg0.getParameter("password");
			 
			 PrintWriter ptr = arg1.getWriter();
			 
			 
			 try {
				 
				 
				 DriverManager.registerDriver(new Driver());
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajit","root","root");
				 PreparedStatement pt = con.prepareStatement("select * from users");
				 boolean flage = false;
				 ResultSet s = pt.executeQuery();
				  
				    while(s.next()) {
				    	if(s.getString(2).equals(myEmail) && s.getString(3).equals(myPassword)) 
				    		flage = true;
				    }
				  
				    if(flage) {
				    	RequestDispatcher rp = arg0.getRequestDispatcher("/Home.jsp");
				    	rp.forward(arg0, arg1);
				    	System.out.println("LOgin ");
				    }
				    else {
				    	
				    
				    	RequestDispatcher rp = arg0.getRequestDispatcher("/login.html");
				    	rp.include(arg0, arg1);
				    	ptr.print("Email and password is dont match");
				    	System.out.println("LOgin failed");
				    }
				 
			 } catch(Exception e) {
				 
				 System.out.println(e);
			 }
		}
}
