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
import com.pms.petopia.domain.Scrap;
import com.pms.petopia.service.ScrapService;

@SuppressWarnings("serial")
@WebServlet("/story/scrapcheck")
public class ScrapCheckHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ScrapService scrapService = (ScrapService) request.getServletContext().getAttribute("scrapService");

    PrintWriter out = response.getWriter();

    try {

      int newsNo = Integer.parseInt(request.getParameter("no"));

      List<Scrap> scrapList = null;
      if ((Member)request.getSession().getAttribute("loginUser") != null) {
        Member loginUser = (Member)request.getSession().getAttribute("loginUser");

        scrapList = scrapService.list(loginUser.getNo());

        for (Scrap scrap : scrapList) {
          if (scrap.getMember().getNo() == loginUser.getNo() && scrap.getStory().getNo() == newsNo) {
            out.print("1");
          } else {
            out.print("0");
          }
        }
      }


    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
