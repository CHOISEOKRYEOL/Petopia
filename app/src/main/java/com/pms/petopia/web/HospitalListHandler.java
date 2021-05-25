package com.pms.petopia.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Bookmark;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.BookmarkService;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.SmallAddressService;

@SuppressWarnings("serial")
@WebServlet("/hospital/list")
public class HospitalListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HospitalService hospitalService = (HospitalService) request.getServletContext().getAttribute("hospitalService");
    BookmarkService bookmarkService = (BookmarkService) request.getServletContext().getAttribute("bookmarkService");
    SmallAddressService smallAddressService = (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    String gno = request.getParameter("gno");
    String cno = request.getParameter("cno");

    try {
      List<Hospital> hospitals = hospitalService.list();
      List<SmallAddress> area = smallAddressService.list();
      if(loginUser != null) {
        List<Bookmark> book = bookmarkService.get(loginUser.getNo());
        request.setAttribute("book", book);
      }

      if (gno != null && cno != null) {
        int cityNo = Integer.parseInt(cno);
        String cityName = smallAddressService.get(cityNo).getName();
        String stateName = smallAddressService.get(cityNo).getBigAddress().getName();
        request.setAttribute("stateName", stateName);
        request.setAttribute("cityName", cityName);
        //이름으로 넘길까? 그래야 검색하지 

      }

      request.setAttribute("list", hospitals);
      request.setAttribute("area", area);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/hospital/list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
