package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
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
    int stateNo= Integer.parseInt(request.getParameter("stateNo")); //일단 가져왔음
    int cityNo = Integer.parseInt(request.getParameter("cityNo"));

    try {
      MyTownBoard myTownBoard = myTownBoardService.get(no);
      List<SmallAddress> smallAddresses = smallAddressService.list();

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      if (loginUser != null && myTownBoard.getWriter().getNo() == loginUser.getNo()) {

      List<MyTownBoardComment> comments = myTownBoardCommentService.list(no);
      int commentCount = myTownBoardCommentService.count(no);
      System.out.println(no);
      System.out.println(commentCount);
      //      int count = 0;
      //      for(MyTownBoardComment c : comments) {
      //        if(myTownBoard.getNo() == c.getMyTownBoard().getNo()) {
      //          out.println("<table border='1'>");
      //          out.println("<tbody>");
      //          out.printf("<tr><th>작성자</th><td>%s</td>\n"
      //              + "<th>작성일</th><td>%s</td></tr>\n"
      //              + "<tr><th>내용</th><td>%s</td></tr>",
      //              c.getWriter().getNick(),
      //              c.getCreatedDate(),
      //              c.getContent());
      //          out.println("<a href='../mytowncomment/delete?no=" + c.getNo() + "'> 삭제</a>  <br>");
      //          //out.println("<a href='../mytowncomment/delete?no=" + c.getNo() + "'> 변경</a>  <br>");
      //          out.println("</tbody>");
      //          out.println("</table>");
      //          out.println("<br>");
      //          count++;
      //        } else {
      //          out.println("댓글 없음");
      //        }
      //      } 
      //      out.println("댓글 수 :" + count);
      //
      //      try {
      //        out.println("<form action='http://localhost:8080/web/mytowncomment/add' method='post'>");
      //        out.printf("<input type='hidden' name='boardNo' value='%d'> <br>\n", myTownBoard.getNo());
      //        out.println("댓글: <textarea name='content' rows='1' cols='30'></textarea><br>");
      //
      //      } catch (Exception e) {
      //        //throw new ServletException(e);
      //        // 상세 오류 내용을 StringWriter로 출력한다.
      //        StringWriter strWriter = new StringWriter();
      //        PrintWriter printWriter = new PrintWriter(strWriter);
      //        e.printStackTrace(printWriter);
      //
      //        // StringWriter에 들어있는 출력 내용을 꺼내 클라이언트로 보낸다.
      //        out.printf("<pre>%s</pre>\n", strWriter.toString());
      //      }
      //      out.println("<input type='submit' value='등록'>");
      //      out.println("</form>");
      //      out.println("</body>");
      //      out.println("</html>");
      //
      //
      request.setAttribute("myTownBoard", myTownBoard);
      request.setAttribute("smallAddresses", smallAddresses);
      request.setAttribute("comments", comments);
      request.setAttribute("commentCount", commentCount);
      request.getRequestDispatcher("/jsp/mytownboard/detail.jsp").include(request, response);
      //request.getRequestDispatcher("/jsp/mytownboardcomment/list.jsp").include(request, response);
    } catch (Exception e) {
      throw new ServletException(e);
    }

    out.println("</body>");
    out.println("</html>");
  }
}






