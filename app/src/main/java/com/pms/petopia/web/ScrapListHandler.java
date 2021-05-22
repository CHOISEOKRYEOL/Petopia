package com.pms.petopia.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Scrap;
import com.pms.petopia.service.ScrapService;

@SuppressWarnings("serial")
@WebServlet("/mypage/scraplist")
public class ScrapListHandler extends HttpServlet{

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ScrapService scrapService = (ScrapService) request.getServletContext().getAttribute("scrapService");
    response.setContentType("text/html;charset=UTF-8");

    try {

      Member loginUser = (Member)request.getSession().getAttribute("loginUser");
      System.out.println(loginUser.getNo());
      List<Scrap> scrapList = scrapService.list(loginUser.getNo());


      System.out.printf("사이즈 : %d\n", scrapList.size());
      String emptyList = null;
      if (scrapList.size() == 0) {
        emptyList = "true";
      }

      request.setAttribute("emptyList", emptyList);
      request.setAttribute("scrapList", scrapList);
      request.getRequestDispatcher("/jsp/mypage/scraplist.jsp").include(request, response);
    } catch (Exception e) {

      throw new ServletException(e);
    }
  }
}
