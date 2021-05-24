package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.ScrapService;

@SuppressWarnings("serial")
@WebServlet("/story/scrapdelete")
public class ScrapDeleteHandler extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ScrapService scrapService = (ScrapService) request.getServletContext().getAttribute("scrapService");
    response.setContentType("text/html;charset=UTF-8");
    int scrapNo = Integer.parseInt(request.getParameter("scrapNo"));

    try {

      Member loginUser = (Member)request.getSession().getAttribute("loginUser");

      scrapService.delete(scrapNo);

      //request.getRequestDispatcher("/jsp/mypage/scrapdelete.jsp").include(request, response);
      response.sendRedirect("../mypage/scraplist");

    } catch (Exception e) {

      throw new ServletException(e);
    }
  }
}
