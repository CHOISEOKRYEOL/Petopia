package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Review;
import com.pms.petopia.service.ReviewService;

@SuppressWarnings("serial")
@WebServlet("/review/list")
public class ReviewListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ReviewService reviewService = (ReviewService) request.getServletContext().getAttribute("reviewService");

    request.setCharacterEncoding("UTF-8");


    Member loginUser = (Member) request.getSession().getAttribute("loginUser");


    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>리뷰 목록</title>");

    Hospital h = new Hospital();
    h.setNo(1);

    try {
      List<Review> list = reviewService.list(h.getNo());

      out.println("</head>");
      out.println("<body>");
      out.printf("<h1>%s 리뷰 목록</h1>\n", h.getName());

      for(Review r : list) {
        if(r.getHospital().getNo() == h.getNo()) {
          out.printf("<p>리뷰내용 : %s</p>\n", r.getComment());
          out.printf("<p>작성자 : %s</p>\n", r.getWriter().getName());
          out.printf("<o>작성일 : %s</p><br>\n", r.getCreatedDate());
          if(r.getWriter().getNo() == loginUser.getNo()) {
            out.println("<a href='delete?no=" + r.getNo() + "'>삭제</a>");
          }
        }
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }

    out.println("<p><a href='../main'>돌아가기</a></p>");
    out.println("</body>");
    out.println("</html>");
  }
}






