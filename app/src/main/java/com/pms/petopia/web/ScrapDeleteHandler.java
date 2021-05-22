package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Scrap;
import com.pms.petopia.service.ScrapService;

@SuppressWarnings("serial")
@WebServlet("/mypage/scrapdelete")
public class ScrapDeleteHandler extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ScrapService scrapService = (ScrapService) request.getServletContext().getAttribute("scrapService");
    response.setContentType("text/html;charset=UTF-8");
    int scrapNo = Integer.parseInt(request.getParameter("scrapNo"));

    try {
      Scrap oldScrap = scrapService.get(scrapNo);
      System.out.println(oldScrap);

      if (oldScrap == null) {
        throw new Exception("해당 번호의 스크랩이 없습니다.");
      }

      Member loginUser = (Member)request.getSession().getAttribute("loginUser");
      System.out.println(oldScrap.getMember());
      System.out.println(loginUser);
      if (oldScrap.getMember().getNo() != loginUser.getNo()) {
        throw new Exception("삭제 권한이 없습니다!");
      }

      scrapService.delete(scrapNo);

      //request.getRequestDispatcher("/jsp/mypage/scrapdelete.jsp").include(request, response);
      response.sendRedirect("scraplist");

    } catch (Exception e) {

      throw new ServletException(e);
    }
  }
}
