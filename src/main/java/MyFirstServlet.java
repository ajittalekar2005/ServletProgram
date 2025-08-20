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
    		
              String myEmail =request.getParameter("email1");
              String myPass =  request.getParameter("password");
              //System.out.println(myEmail+"\n"+myPass);
              if(myEmail.equals("ajittalekar@gmail.com") && myPass.equals("ajit123")) {
            	   response.sendRedirect("https://leetcode.com/");
              }
             
    }
}
 