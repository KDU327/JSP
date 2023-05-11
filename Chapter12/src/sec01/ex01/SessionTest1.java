package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setAttribute("name", "김동욱");
		out.println("<html><body>");
		out.println("<h1>세션에 이름을 바인딩합니다.<h1>");
		out.println("<a href='/Chapter12/test01/session1.jsp'>첫 번째 페이지로 이동하기</a>");
		out.println("</body></html>");
	}

}
