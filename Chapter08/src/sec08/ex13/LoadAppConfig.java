package sec08.ex13;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "loadConfig", urlPatterns = {"/loadConfig"}, loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	// 변수 context를 멤버 변수로 선언
	private ServletContext context;
    
	public void init(ServletConfig config) throws ServletException {
      // init() 메서드에서 ServletContext 객체 얻음
      System.out.println("LoadAppConfig의 init 메서드 호출");
      context = config.getServletContext();
     
      // getInitParameter() 메서드에서 web.xml의 메뉴 정보를 읽어 옴. 
      String menu_member = context.getInitParameter("menu_member");
      String menu_order  = context.getInitParameter("menu_order");
      String menu_goods  = context.getInitParameter("menu_goods");
		
      context.setAttribute("menu_member", menu_member);
      context.setAttribute("menu_order", menu_order);
      context.setAttribute("menu_goods", menu_goods);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ServletContext context = getServletContext();
		String menu_member = (String)context.getAttribute("menu_member");
        String menu_order  = (String)context.getAttribute("menu_order");
        String menu_goods  = (String)context.getAttribute("menu_goods");
		
		out.print("<html><body>");
	    out.print("<table border=1 cellspacing=0><tr>메뉴이름<tr>");
	    out.print("<tr><td>" + menu_member + "</td></tr>");
	    out.print("<tr><td>" + menu_order + "</td></tr>");
	    out.print("<tr><td>" + menu_goods + "</td></tr>");
	    out.print("</tr></table></body></html>");
	}

}
