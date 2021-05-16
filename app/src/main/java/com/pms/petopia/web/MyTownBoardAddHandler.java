package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.SmallAddressService;

@SuppressWarnings("serial")
@WebServlet("/mytown/add")
public class MyTownBoardAddHandler extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    SmallAddressService smallAddressService = (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>우리동네 새 게시글</title>");
    out.println("</head>");
    out.println("<body>");

    int stateNo= Integer.parseInt(request.getParameter("stateNo")); //일단 가져왔음
    int cityNo = Integer.parseInt(request.getParameter("cityNo"));
    try {
      SmallAddress small = smallAddressService.get(cityNo);
      out.printf("<h1>%s %s</h1>", small.getBigAddress().getName(), small.getName());

      out.println("<h2>우리동네 새 게시글</h2>");
      out.println("<form action='add' method='post'>");
      //
      List<SmallAddress> smallAddress = smallAddressService.list();
      out.println("광역시/도 : ");
      out.println("<select name ='stateNo'>\n");
      for (SmallAddress s : smallAddress) {
        if (s.getBigAddress().getNo() == stateNo) {
          out.printf("<option value='%d' selected>%s</option>\n", s.getBigAddress().getNo(), s.getBigAddress().getName());
        } else {
          out.printf("<option value='%d'>%s</option>\n", s.getBigAddress().getNo(), s.getBigAddress().getName());
        }
      }
      out.println("</select>\n");

      out.println("시/군/구 : ");
      out.println("<select name='cityNo'>\n");
      for (SmallAddress s : smallAddress) {
        if (s.getNo() == cityNo) {
          out.printf("<option value='%d' selected>%s</option>\n", s.getNo(), s.getName());
        } else {
          out.printf("<option value='%d'>%s</option>\n", s.getNo(), s.getName());
        }
      }
      out.println("</select><br>\n");
      //
      //out.printf("지역: <input type='hidden' name='cityNo' value ='%d' readonly> <br>\n", small.getNo());
      out.println("제목: <input type='text' name='title'><br>");
      out.println("내용: <textarea name='content' rows='10' cols='60'></textarea><br>");

      out.printf("<a href='list?stateNo=%d&cityNo=%d'>목록</a>",small.getBigAddress().getNo(), small.getNo());

    } catch (Exception e) {
      throw new ServletException(e);
    }
    out.println("<input type='submit' value='등록'>");

    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardService myTownBoardService = (MyTownBoardService)request.getServletContext().getAttribute("myTownBoardService");
    SmallAddressService smallAddressService = (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");

    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();

    MyTownBoard b = new MyTownBoard();

    try {
      int no = Integer.parseInt(request.getParameter("cityNo"));
      SmallAddress s = smallAddressService.get(no);
      b.setSmallAddress(s);
      b.setTitle(request.getParameter("title"));
      b.setContent(request.getParameter("content"));
      Member loginUser = (Member)request.getSession().getAttribute("loginUser");
      b.setWriter(loginUser);


      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>게시글 등록</title>");

      myTownBoardService.add(b);
      String webAdress= String.format("list?stateNo=%s&cityNo=%s", s.getBigAddress().getNo(), s.getNo());
      response.sendRedirect(webAdress);

    } catch (Exception e) {
      throw new ServletException(e);
    }
    out.println("</body>");
    out.println("</html>");
  }
}




