package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;

@SuppressWarnings("serial")
@WebServlet("/member/detail")
public class MemberDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>내 계정 관리</title>");
    out.println("</head>");
    out.println("<body>");

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    try {

      Member m = loginUser;

      out.println("<form action='update' method='post'>");
      out.println("<table border='1'>");
      out.println("<tbody>");
      out.printf("<tr><th>이름</th>"
          + " <td><input name='name' value='%s' readonly></td></tr>\n", m.getName());
      out.printf("<tr><th>아이디</th>"
          + " <td><input name='id' value='%s' readonly></td></tr>\n", m.getId());
      out.printf("<tr><th>이메일</th>"
          + " <td><input name='email' value='%s' readonly></td></tr>\n", m.getEmail());
      out.printf("<tr><th>닉네임</th>"
          + " <td><input name='nick' type='text'></td></tr>\n", m.getNick());
      out.println("<tr><th>비밀번호</th>"
          + " <td><input name='password' type='password'></td></tr>\n");
      out.println("<tr><th>비밀번호 확인</th>"
          + " <td><input name='checkPassword' type='password'></td></tr>\n");
      out.printf("<tr><th>휴대전화</th>"
          + " <td><input name='tel' type='tel'></td></tr>\n", m.getTel());
      out.println("<input type='submit' value='수정' ");
      //      out.println("<button type='button' value='취소' onClick='main'");
      out.println("</tbody>");
      out.println("</table>");
      out.println("</form>");
      out.println("<form action='delete' method='post'>");
      out.println("<input type='submit' name='delete' value='회원탈퇴'>");
      out.println("</form>");

      out.println("<p><a href='main'>메인 화면</a></p>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }
    out.println("</body>");
    out.println("</html>");
  }
}






