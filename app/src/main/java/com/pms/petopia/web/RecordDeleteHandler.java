package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.service.RecordService;

@SuppressWarnings("serial")
@WebServlet("/record/delete")
public class RecordDeleteHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RecordService recordService = (RecordService) request.getServletContext().getAttribute("RecordService");

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("[진료기록 삭제]");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      if (recordService.delete(no) == 0) {
        out.println("해당 번호의 펫이 없습니다.");
      } else {
        out.println("펫을 삭제하였습니다.");
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

}
