package sec02.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sec01.ex01.MemberDAO;
import sec01.ex01.MemberVO;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    MemberDAO dao = new MemberDAO();
	    List<MemberVO> list = dao.listMembers();
		      
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>ID</td><td>pw</td><td>name</td><td>email</td><td>sdate</td></tr>");
		    
		for (int i = 0; i<list.size(); i++) {
		  MemberVO memberVO = list.get(i);
		  String id = memberVO.getId();
		  String pwd = memberVO.getPwd();
		  String name = memberVO.getName();
		  String email = memberVO.getEmail();
		  Date joinDate = memberVO.getJoinDate();
		  out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate + "</td></tr>");
		  }
		out.print("</table></body></html>");
	}

}
