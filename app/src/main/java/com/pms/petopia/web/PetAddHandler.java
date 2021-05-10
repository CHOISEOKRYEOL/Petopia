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
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.domain.Type;
import com.pms.petopia.service.PetService;

@SuppressWarnings("serial")
@WebServlet("/pet/add")
public class PetAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PetService petService = (PetService) request.getServletContext().getAttribute("petService");

    // 클라이언트가 POST 요청으로 보낸 데이터가 UTF-8임을 알려준다.
    request.setCharacterEncoding("UTF-8");

    Pet p = new Pet();
    p.setName(request.getParameter("name"));
    p.setAge(Integer.parseInt(request.getParameter("age")));
    p.setBirthDay(Date.valueOf(request.getParameter(("birth"))));
    p.setGender(Integer.parseInt(request.getParameter("gender")));
    p.setPhoto(request.getParameter("photo"));

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    p.setOwner(loginUser);

    Type t = new Type();
    t.setNo(1);
    t.setType(1);
    p.setType(t);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<h1>마이펫 등록</h1>");

    try {
      petService.add(p);

      out.println("<meta http-equiv='Refresh' content='1;url=../main'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>마이펫 등록</h1>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>마이펫 등록 오류</h1>");
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}
