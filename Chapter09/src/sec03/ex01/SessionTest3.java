package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		// 생성된 객체 아이디 가져옴.
		out.println("세션 아이디 : " + session.getId() + "<br>");
		// 최초 세션 객체 생성 시간 가져옴.
		out.println("최초 세션 생성 시각 : " + new Date(session.getCreationTime()) + "<br>");
		// 세션 객체에 가장 최근에 접근한 시간 가져옴.
		out.println("최초 세션 접근 시각 : " + new Date(session.getLastAccessedTime()) + "<br>");
		// 세션 객체의 유효 시간을 가져옴.
		out.println("기본 세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		
		if(session.isNew()) {
			out.print("새 세션이 만들어졌습니다.");
		}
		
		// 생성된 세션 객체를 강제로 삭제.
		session.invalidate();
	}

}