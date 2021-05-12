package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.BigAddress;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.BigAddressService;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.SmallAddressService;

@SuppressWarnings("serial")
@WebServlet("/mytown/add")
public class MyTownBoardAddHandler extends HttpServlet{

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    SmallAddressService smallAddressService = (SmallAddressService)request.getServletContext().getAttribute("smallAddressService");
    BigAddressService bigAddressService = (BigAddressService)request.getServletContext().getAttribute("bigAddressService");
    MyTownBoardService myTownBoardService = (MyTownBoardService)request.getServletContext().getAttribute("myTownBoardService");

    MyTownBoard b = new MyTownBoard();

    b.setTitle(request.getParameter("title"));
    b.setContent(request.getParameter("content"));
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    b.setWriter(loginUser);

    BigAddress ba = new BigAddress();
    //    ba.setNo(Integer.parseInt(request.getParameter("stateNo")));
    int num = Integer.parseInt(request.getParameter("stateNo"));
    ba.setNo(3);
    ba.setName(setBigAddress(num));

    SmallAddress sa = new SmallAddress();
    //    sa.setNo(Integer.parseInt(request.getParameter("cityNo")));
    int num2 = Integer.parseInt(request.getParameter("cityNo"));
    sa.setNo(5);
    sa.setName(setSmallAddress(num2));
    sa.setBigAddress(ba);

    b.setSmallAddress(sa);
    //    b.setBigAddress(ba);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>게시글 등록</title>");
    out.println("</head>");
    out.println("<body>");

    try {
      bigAddressService.add(ba);
      smallAddressService.add(sa);
      myTownBoardService.add(b);

      out.println("<p>게시글을 등록했습니다.<p>");

      response.setHeader("Refresh", "1;url=../main");
    } catch (Exception e) {
      // 상세 오류 내용을 StringWriter로 출력한다.
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>게시글 등록 오류</h1>");
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<a href='list'>목록</a></p>\n");
    }
    out.println("</body>");
    out.println("</html>");
  }

  private String setBigAddress(int no) {
    switch(no) {
      case 1: return "서울특별시";
      case 2: return "경기도";
      case 3: return "인천광역시";
      default: return null;
    }
  }

  private String setSmallAddress(int no) {
    switch(no) {
      case 1: return "강남구";
      case 2: return "서초구";
      case 3: return "종로구";
      case 4: return "중구";
      case 5: return "성북구";
      case 6: return "성남시";
      case 7: return "안양시";
      case 8: return "광명시";
      case 9: return "안산시";
      case 10: return "시흥시";
      case 11: return "서구";
      case 12: return "동구";
      case 13: return "중구";
      case 14: return "남구";
      case 15: return "부평구";
      case 16: return "계양구";
      case 17: return "연수구";
      default: return null;
    }
  }

}


