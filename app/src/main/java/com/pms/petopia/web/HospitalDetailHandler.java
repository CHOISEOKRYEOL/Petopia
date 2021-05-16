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
import com.pms.petopia.domain.Review;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.ReviewService;

@SuppressWarnings("serial")
@WebServlet("/hospital/detail")
public class HospitalDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HospitalService hospitalService = (HospitalService) request.getServletContext().getAttribute("hospitalService");
    ReviewService reviewService = (ReviewService) request.getServletContext().getAttribute("reviewService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>병원 상세</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>병원 상세보기</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Hospital hospital = hospitalService.get(no);
      if (hospital == null) {
        out.println("<p>해당 번호의 스토리가 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      out.println("<form action='update' method='post' enctype='multipart/form-data'>");
      out.println("<table border='1'>");
      out.println("<tbody>");
      out.printf("<tr><th>번호</th> <td><input type='text' name='no' value='%d' readonly></td></tr>\n", hospital.getNo());
      out.printf("<tr><th>병원이름</th> <td><input type='text' name='name' value='%s'></td></tr>\n", hospital.getName());
      out.printf("<tr><th>전화번호</th> <td><input type='tel' name='tel' value='%s'></td></tr>\n", hospital.getTel());

      out.println("<tr><th>기본주소</th> <td><select name='gno'><option value=''>분류</option>"
          + "<option value='1'>서울특별시</option>\n"
          + "<option value='2'>경기도</option>\n"
          + "<option value='3'>인천광역시</option></select>");
      out.println("<select name='cno'><option value=''>분류</option>"
          + "<optgroup label='서울특별시'>"
          + "<option value='1'>강남구</option></optgroup>\n"
          + "<optgroup label='경기도'>"
          + "<option value='2'>김포시</option></optgroup>\n"
          + "<optgroup label='인천광역시'>"
          + "<option value='3'>중구</option></optgroup></select></td></tr>");

      out.printf("<tr><th>상세주소</th> <td><input type='text' name='address' value='%s'></td></tr>\n", hospital.getAddress());
      out.printf("<tr><th>진료시간</th> <td><input type='number' name='startTime' value='%d'>"
          + "<input type='number' name='endTime' value='%d'></td></tr>\n", 
          hospital.getStartTime(), hospital.getEndTime());

      if (hospital.getParking() == 1) {
        out.println("<tr><th>주차여부</th> <td><input type='radio' name='parking' value='1' checked>Yes"
            + "<input type='radio' name='parking' value='0'>No</td></tr>\n");
      } else if (hospital.getParking() == 0) {
        out.println("<tr><th>주차여부</th> <td><input type='radio' name='parking' value='1'>Yes"
            + "<input type='radio' name='parking' value='0' checked>No</td></tr>\n");
      }

      out.printf("<tr><th>수의사</th> <td><input type='number' name='vet' value='%d'></td></tr>\n", hospital.getVeterinarian());

      out.printf("<tr><th>사진</th> <td><a href='%s'><img src='%s'></a><br>"
          + "<input name='photo' type='file'></td></tr>\n",
          hospital.getPhoto() != null ? "../upload/" + hospital.getPhoto() : "",
              hospital.getPhoto() != null ? "../upload/" + hospital.getPhoto() + "_300x300.jpg" : "../images/person_300x300.jpg");

      out.println("</tbody>");

      out.println("<tfoot>");
      out.println("<tr><td colspan='2'>");
      out.println("<input type='submit' value='변경'>");
      out.printf("<a href='delete?no=%d'>삭제</a>\n", hospital.getNo());
      out.println("</td></tr>");
      out.println("</tfoot>");

      out.println("</table>");
      out.println("</form>");
      out.println("<br>");
      out.printf("<h1> %s 의 리뷰 </h1>\n", hospital.getName());
      List<Review> reviews = reviewService.list(no);

      for(Review r : reviews) {
        if(hospital.getNo() == r.getHospital().getNo()) {
          out.println("<table border='1'>");
          out.println("<tbody>");
          out.printf("<tr>"
              + " <td>서비스 : %d점</td>"
              + " <td>청결도 : %d점</td>"
              + " <td>비용 : %d점</td>"
              + " <td>내용 : %s</td>"
              + " <td>작성일 : %s</td>"
              + " <td>작성자 : %s</td>"
              + " <td>영수증 : <img src='%s'></td> </tr>\n",
              r.getServiceRating(),
              r.getCleanlinessRating(),
              r.getCostRating(),
              r.getComment(),
              r.getCreatedDate(),
              r.getWriter().getNick(),
              r.getPhoto());
          out.println("</tbody>");
          out.println("</table>");
        }
        out.println("<br>");
      }

    } catch (Exception e) {
      throw new ServletException(e);
    }
    out.println("<p><a href='list'>목록</a></p>");

    out.println("</body>");
    out.println("</html>");
  }
}
