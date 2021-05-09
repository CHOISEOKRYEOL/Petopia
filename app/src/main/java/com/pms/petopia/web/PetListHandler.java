package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.service.PetService;

@SuppressWarnings("serial")
@WebServlet("/pet/list")
public class PetListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 클라이언트가 /board/list 를 요청하면 톰캣 서버가 이 메서드를 호출한다. 

    PetService petMemberService = (PetService) request.getServletContext().getAttribute("PetMemberService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>마이펫 목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>마이펫 목록</h1>");

    out.println("<p><a href='form.html'>새 글</a></p>");

    try {
      List<Pet> pets = petMemberService.list();

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>번호</th> <th>이름</th> <th>나이</th> <th>생일</th> <th>품종</th> <th>사진</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (Pet p : pets) {
        out.printf("<tr>"
            + " <td>%d</td>"
            + " <td><a href='detail?no=%1$d'>%s</a></td>"
            + " <td>%s</td>"
            + " <td>%b</td>"
            + " <td>%d</td> </tr>\n", 
            p.getNo(), 
            p.getName(), 
            p.getAge(),
            p.getBirthDay(),
            p.isGender(), 
            p.getPhoto());
      }
      out.println("</tbody>");
      out.println("</table>");


    } catch (Exception e) {
      // 상세 오류 내용을 StringWriter로 출력한다.
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      // StringWriter 에 들어 있는 출력 내용을 꺼내 클라이언트로 보낸다.
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}





