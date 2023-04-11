package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// getCookies() 메소드를 호출해 브라우저에서 쿠키 정보를 요청한 후 쿠키 정보를 배열로 가져옴.
		Cookie[] allValues = request.getCookies();
		
		// 배열에 저장할 때 사용한 쿠키 이름인 cookieTestfh로 검색해 쿠키 값을 가져옴.
		for(int i=0; i<allValues.length; i++) {
			if(allValues[i].getName().equals("cookieTest")) {
				out.println("<h2> Cookie값 가져오기 : " + URLDecoder.decode(allValues[i].getValue(), "utf-8"));
			}
		}
	}

}
