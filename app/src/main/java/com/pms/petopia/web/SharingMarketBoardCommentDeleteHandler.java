package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.service.SharingMarketBoardCommentService;

@SuppressWarnings("serial")
@WebServlet("/sharingmarketboardcomment/delete")
public class SharingMarketBoardCommentDeleteHandler extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    SharingMarketBoardCommentService sharingMarketBoardCommentService = (SharingMarketBoardCommentService)request.getServletContext().getAttribute("sharingMarketBoardCommentService");
    try {

      int no = Integer.parseInt(request.getParameter("no"));
      System.out.println(no);
      PrintWriter out = response.getWriter();
      out.print("working");
      sharingMarketBoardCommentService.delete(no);

    } catch (Exception e) {
      throw new ServletException(e);

    }


  }

}
