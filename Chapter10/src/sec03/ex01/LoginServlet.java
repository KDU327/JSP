package sec03.ex01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");
		// response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		
		out.println("<html><body>");
		out.println("이름은 " + user_name + "<br>");
		out.println("비밀번호는 " + user_pwd + "<br>");
		out.println("</body></html>");
	}

}
