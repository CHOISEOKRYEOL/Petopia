package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.SmallAddressService;

@SuppressWarnings("serial")
@WebServlet("/mytown/list")

public class MytownBoardListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardService myTownBoardService = (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");
    SmallAddressService smallAddressService = (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    int stateNo = Integer.parseInt(request.getParameter("stateNo"));
    int cityNo = Integer.parseInt(request.getParameter("cityNo"));
    String keyword = request.getParameter("keyword");

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.printf("<title>우리동네 게시글 목록</title>\n");
    out.println("</head>");
    out.println("<body>");

    try {
      List<MyTownBoard> boards = myTownBoardService.list(cityNo,stateNo);
      SmallAddress s = smallAddressService.get(cityNo);
      out.printf("<h1>%s %s</h1>", s.getBigAddress().getName(), s.getName());

      if(boards.size() > 0) {

        MyTownBoard board = boards.get(0);

        out.printf("<p><a href='add?stateNo=%d&cityNo=%d'>새 글</a><p>", board.getBigAddress().getNo(), board.getSmallAddress().getNo());

        if (keyword != null && keyword.length() > 0) {
          boards = myTownBoardService.search(stateNo, cityNo, keyword);
        } else {
          boards = myTownBoardService.list(stateNo, cityNo);
        }

        out.println("<table border='1'>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<th>번호</th> <th>제목</th> <th>작성자</th> <th>등록일</th> <th>조회수</th> <th>댓글수</th>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");


        for (MyTownBoard b : boards) {
          out.printf("<tr>"
              + " <td>%d</td>"
              + " <td><a href='detail?no=%1$d'>%s</a></td>"
              + " <td>%s</td>"
              + " <td>%s</td>"
              + " <td>%d</td>"
              + " <td>%d</td></tr>\n", 
              b.getNo(), 
              b.getTitle(), 
              b.getWriter().getNick(),
              b.getCreatedDate(),
              b.getViewCount(),
              b.getCommentCount());
        }

        out.println("</tbody>");
        out.println("</table>");

        out.println("<form action='list' method='get'>");
        out.printf("<input type='text' name='stateNo' value='%d' readonly><br>\n",
            s.getBigAddress().getNo());
        out.printf("<input type='text' name='cityNo' value='%d' readonly><br>\n",
            s.getNo());
        out.printf("<input type='search' name='keyword' value='%s'>\n",
            keyword != null ? keyword : "");
        out.println("<button> 검색 </button>");
        out.println("</form>");
      } else {
        out.println("우리동네에 게시글이 없습니다.");
      }
    } catch (Exception e) {
      // 상세 오류 내용을 StringWriter로 출력한다.
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      // StringWriter에 들어있는 출력 내용을 꺼내 클라이언트로 보낸다.
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }
    out.println("</body>");
    out.println("</html>");
  }



}






