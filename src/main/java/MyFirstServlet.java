//sendRedirectMethod  HttpServletResponce method to move flow in mensionnedd url 
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/aaa")

public class MyFirstServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    		
              String mySearch =request.getParameter("url");
           
              response.sendRedirect(" https://www."+mySearch+".com/");
            
             
//               https://leetcode.com/
//            	   https://www.geeksforgeeks.org/
//            		   https://www.youtube.com/
    }
}
 