package sec08.ex10;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sec08.ex08.MemberVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

public class ContextParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		// ServletContext 객체 가져옴.
		ServletContext context = getServletContext();
		
		// web.xml의 <param-name>태그의 이름으로 <param-value>태그의 값인 메뉴 이름들을 받아 옴.
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		
		out.print("<html><body>");
	    out.print("<table border=1 cellspacing=0><tr>메뉴이름<tr>");
	    out.print("<tr><td>" + menu_member + "</td></tr>");
	    out.print("<tr><td>" + menu_order + "</td></tr>");
	    out.print("<tr><td>" + menu_goods + "</td></tr>");
	    out.print("</tr></table></body></html>");
		
	}

}
