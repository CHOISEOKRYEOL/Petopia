package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.service.PetService;

@SuppressWarnings("serial")
@WebServlet("/pet/detail")
public class PetDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PetService petService = (PetService) request.getServletContext().getAttribute("petService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    int no = Integer.parseInt(request.getParameter("no"));

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>마이펫 상세보기</title>");
    out.println("</head>");
    out.println("<body>");

    try {

      Pet p = petService.get(no);

      if (p == null) {
        out.println("<p>해당 번호의 펫이 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      out.println("<form action='update' method='post'>");
      out.println("<table border='1'>");
      out.println("<tbody>");
      out.printf("<input type='hidden' name='no' value='%d'>\n", p.getNo());
      out.printf("<tr><th>이름</th>"
          + " <td><input name='name' value='%s' ></td></tr>\n", p.getName());
      out.printf("<tr><th>나이</th>"
          + " <td><input name='age' value='%d' readonly></td></tr>\n", p.getAge());
      out.printf("<tr><th>생일</th>"
          + " <td><input name='birthDay' value='%s' readonly></td></tr>\n", p.getBirthDay());
      out.printf("<tr><th>성별</th>"
          + " <td><input name='gender' value='%d' readonly></td></tr>\n", p.getGender());
      out.printf("<tr><th>사진</th>"
          + " <td><input name='photo' type='file' value='%s'></td></tr>\n", p.getPhoto());
      out.printf("<tr><th>품종</th>"
          + " <td><input name='type' type='type' readonly></td></tr><br>\n", p.getType());
      out.println("</tbody>");
      out.println("</table>");
      out.println("<input type='submit' value='수정' ></form>");
      out.println("<form action='delete' method='post'>");
      out.printf("<input type='hidden' name='no' value='%d'>\n", p.getNo());
      out.println("<input type='submit' value='삭제'></form>");
      out.println("</tbody>");

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser != null && p.getOwner().getNo() == loginUser.getNo()) {
        out.println("<tfoot>");
        out.println("<tr><td colspan='2'>");
        out.println("<input type='submit' value='변경'> "
            + "<a href='delete?no=" + p.getNo() + "'>삭제</a> ");
        out.println("</td></tr>");
        out.println("</tfoot>");
      }

      out.println("</table>");
      out.println("</form>");


    } catch (Exception e) {
      throw new ServletException(e);
    }
    out.println("</body>");
    out.println("</html>");
  }
}






