package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doHandle(request, response);
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
	  PrintWriter out = response.getWriter();
	  MemberDAO dao   = new MemberDAO();
	  
	  String command=request.getParameter("command");
	  if (command != null && command.equals("addMember")) {
        String _id    = request.getParameter("id");
        String _pwd   = request.getParameter("pwd");
        String _name  = request.getParameter("name");
        String _email = request.getParameter("email");
        
        MemberVO vo   = new MemberVO();
        vo.setId(_id);
        vo.setPwd(_pwd);
        vo.setName(_name);
        vo.setEmail(_email);
        dao.addMember(vo);
	  }

	  List<MemberVO> list = dao.listMembers();
      out.print("<html><body>");
      out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
      out.print("<td>ID</td><td>pw</td><td>name</td><td>email</td><td>sdate</td></tr>");
		    
      for (int i = 0; i<list.size(); i++) {
        MemberVO memberVO = list.get(i);
        String id         = memberVO.getId();
        String pwd        = memberVO.getPwd();
        String name       = memberVO.getName();
        String email      = memberVO.getEmail();
        Date joinDate     = memberVO.getJoinDate();
        out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate + "</td></tr>");
      }
      out.print("</table></body></html>");
      out.print("<a href='/Chapter07/memberForm.html'>새 회원 등록하기</a>");
	}

}
