package sec08.ex12;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		// getServletContext 객체 가져오기
		ServletContext context = getServletContext();
		InputStream is = context.getResourceAsStream("/WEB-INF/bin/init.txt");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		
		out.print("<html><body>");
		out.print("<table><tbr>");
		out.print("<td>email: </td><td>" + email + "</td></tr>");
		out.print("<tr><td>휴대전화: </td><td>" + tel + "</td></tr>");
		out.print("</table>");
		out.print("</body></html>");
	}

}
