package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request.setCharacterEncoding("utf-8");
		// response.setContentType("text/html;charset=utf-8");
		PrintWriter out     = response.getWriter();
		HttpSession session = request.getSession();

		String user_id      = request.getParameter("user_id");
		String user_pwd     = request.getParameter("user_pwd");
		LoginImpl loginUser = new LoginImpl(user_id, user_pwd);
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
		}

		out.println("<head>");
		out.println("<script type='text/javascript'>");
		// 자바스크립트의 setTimeout() 함수로 5초마다 서블릿에 재요청하여 접속자수 표시
		out.println("setTimeout('history.go(0);', 5000)");
		out.println("</script>");
		out.println("</head>");
		
		out.println("<html><body>");
		out.println("아이디 : " + loginUser.user_id + "<br>");
		out.println("총 접속자 수 : " + LoginImpl.total_user + "<br>");
		out.println("</body></html>");
	}

}
