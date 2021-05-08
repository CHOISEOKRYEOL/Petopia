package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.PetMember;
import com.pms.petopia.service.PetMemberService;

@SuppressWarnings("serial")
@WebServlet("/pet/add")
public class PetAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PetMemberService petMemberService = (PetMemberService) request.getServletContext().getAttribute("PetMemberService");

    PetMember p = new PetMember();

    // 클라이언트가 POST 요청으로 보낸 데이터가 UTF-8임을 알려준다.
    request.setCharacterEncoding("UTF-8");

    p.setName(request.getParameter("name"));
    p.setAge(Integer.parseInt(request.getParameter("age")));
    p.setBirth(Date.valueOf(request.getParameter(("birth"))));
    p.setGender(Integer.parseInt(request.getParameter("gender")));
    p.setPhoto(request.getParameter("photo"));


    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>마이펫 등록</title>");

    try {
      petMemberService.add(p);

      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>마이펫 등록</h1>");
      out.println("<p>마이펫을 등록했습니다.</p>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>마이펫 등록 오류</h1>");
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<p><a href='list'>목록</a></p>");
    }

    out.println("</body>");
    out.println("</html>");
  }


}
