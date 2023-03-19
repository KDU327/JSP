package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
      System.out.println("init 메소드 호출");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();
      String id = request.getParameter("user_id");
      String pw = request.getParameter("user_pw");
      
      System.out.println("ID : " + id);
      System.out.println("PW : " + pw);
      
      if(id != null && (id.length() != 0) && pw != null && (pw.length() != 0)) {
          if(id.equals("admin")) {
        	out.print("<html>");
            out.print("<body>");
            out.print("<font size='12'>Login To Admin!!</font>");
            out.print("<br>");
            out.print("<input type=button value='Change Information'/>");
            out.print("<input type=button value='Delete Information'/>");
            out.print("</body>");
            out.print("</html>");  
          }else {
           out.print("<html>");
           out.print("<body>");
           out.print(id + " Welcome!!!");
           out.print("</body>");
           out.print("</html>");
          }
        }else {
          out.print("<html>");
          out.print("<body>");
          out.print("Please Enter Your ID And Password!!!");
          out.print("<br>");
          out.print("<a href='http://localhost:8090/Chapter06/Test01/logintest.html'>Move to Login Window</a>");
          
          out.print("</body>");
          out.print("</html>");
        }
	}

	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}

}
