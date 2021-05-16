package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.MyTownBoardComment;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.MyTownBoardCommentService;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.SmallAddressService;

@SuppressWarnings("serial")
@WebServlet("/mytown/detail")
public class MyTownBoardDetailHandler extends HttpServlet {

  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardService myTownBoardService = (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");
    SmallAddressService smallAddressService = (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");
    MyTownBoardCommentService myTownBoardCommentService = (MyTownBoardCommentService) request.getServletContext().getAttribute("myTownBoardCommentService");
    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();
    int no = Integer.parseInt(request.getParameter("no"));

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>게시글 상세</title>");
    out.println("</head>");
    out.println("<body>");

    int stateNo= Integer.parseInt(request.getParameter("stateNo")); //일단 가져왔음
    int cityNo = Integer.parseInt(request.getParameter("cityNo"));

    try {
      MyTownBoard b = myTownBoardService.get(no);
      if (b == null) {
        out.println("<p>해당 번호의 게시글이 없습니다.</p>");
        return;
      }
      out.printf("<h1>%s %s</h1>", b.getBigAddress().getName(), b.getSmallAddress().getName());
      out.println("<h2>게시글 상세보기</h2>");
      out.printf("<form action='update' method='post'>",
          b.getBigAddress().getNo(), b.getSmallAddress().getNo());
      out.println("<table border='1'>");
      out.println("<tbody>");
      //

      List<SmallAddress> smallAddress = smallAddressService.list();
      out.println("<tr><th>광역시/도</th> ");
      out.println("<td><select name ='stateNo'>\n");
      for (SmallAddress s : smallAddress) {
        if (s.getBigAddress().getNo() == stateNo) {
          out.printf("<option value='%d' selected>%s</option>\n", s.getBigAddress().getNo(), s.getBigAddress().getName());
        } else {
          out.printf("<option value='%d'>%s</option>\n", s.getBigAddress().getNo(), s.getBigAddress().getName());
        }
      }
      out.println("</select></td></tr>\n");

      out.println("<tr><th>시/군/구</th> ");
      out.println("<td><select name='cityNo'>\n");
      for (SmallAddress s : smallAddress) {
        if (s.getNo() == cityNo) {
          out.printf("<option value='%d' selected>%s</option>\n", s.getNo(), s.getName());
        } else {
          out.printf("<option value='%d'>%s</option>\n", s.getNo(), s.getName());
        }
      }
      out.println("</select></td></tr><br>\n");

      out.printf("<tr><th>번호</th>"
          + " <td><input type='text' name='no' value='%d'readonly></td></tr>\n", b.getNo());
      out.printf("<tr><th>제목</th> "
          + "<td><input name='title' type='text' value='%s'></td></tr>\n", b.getTitle());
      out.printf("<tr><th>내용</th> "
          + "<td><textarea name='content' rows='10'>%s</textarea></td></tr>\n", b.getContent());
      out.printf("<tr><th>작성자</th> <td>%s</td></tr>\n", b.getWriter().getNick());
      out.printf("<tr><th>등록일</th> <td>%s</td></tr>\n", formatter.format(b.getCreatedDate()));
      out.printf("<tr><th>조회수</th> <td>%s</td></tr>\n", b.getViewCount());
      //out.printf("<tr><th>댓글</th> <td>%s</td></tr>\n",b.getComment());
      out.println("</tbody>");

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser != null && b.getWriter().getNo() == loginUser.getNo()) {

        out.println("<tfoot>");
        out.println("<tr><td colspan='2'>");
        out.println("<input type='submit' value='변경'>"
            + "<a href='delete?no=" + b.getNo() + "'> 삭제</a> ");
        out.println("</td></tr>");
        out.println("</tfoot>");
      }

      out.println("</table>");
      out.printf("</form>");
      out.printf("<a href='list?stateNo=%d&cityNo=%d'>목록</a></p>\n", b.getBigAddress().getNo(), b.getSmallAddress().getNo());
      out.println("<br>");
      List<MyTownBoardComment> comments = myTownBoardCommentService.list(no);
      int count = 0;
      for(MyTownBoardComment c : comments) {
        if(b.getNo() == c.getMyTownBoard().getNo()) {
          out.println("<table border='1'>");
          out.println("<tbody>");
          out.printf("<tr><th>작성자</th><td>%s</td>\n"
              + "<th>작성일</th><td>%s</td></tr>\n"
              + "<tr><th>내용</th><td>%s</td></tr>",
              c.getWriter().getNick(),
              c.getCreatedDate(),
              c.getContent());
          out.println("<a href='../mytowncomment/delete?no=" + c.getNo() + "'> 삭제</a>  <br>");
          //out.println("<a href='../mytowncomment/delete?no=" + c.getNo() + "'> 변경</a>  <br>");
          out.println("</tbody>");
          out.println("</table>");
          out.println("<br>");
          count++;
        } else {
          out.println("댓글 없음");
        }
      } 
      out.println("댓글 수 :" + count);

      try {
        out.println("<form action='http://localhost:8080/web/mytowncomment/add' method='post'>");
        out.printf("<input type='hidden' name='boardNo' value='%d'> <br>\n", b.getNo());
        out.println("댓글: <textarea name='content' rows='1' cols='30'></textarea><br>");

      } catch (Exception e) {
        //throw new ServletException(e);
        // 상세 오류 내용을 StringWriter로 출력한다.
        StringWriter strWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(strWriter);
        e.printStackTrace(printWriter);

        // StringWriter에 들어있는 출력 내용을 꺼내 클라이언트로 보낸다.
        out.printf("<pre>%s</pre>\n", strWriter.toString());
      }
      out.println("<input type='submit' value='등록'>");
      out.println("</form>");
      out.println("</body>");
      out.println("</html>");

    } catch (Exception e) {
      throw new ServletException(e);
    }

    out.println("</body>");
    out.println("</html>");
  }
}






