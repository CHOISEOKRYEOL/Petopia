package com.pms.petopia.web;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.service.RecordService;

@Controller
public class RecordDeleteHandler {

  RecordService recordService;

  public RecordDeleteHandler(RecordService recordService) {
    this.recordService = recordService;
  }

  @RequestMapping("/record/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("[진료기록 삭제]");

    int no = Integer.parseInt(request.getParameter("no"));

    if (recordService.delete(no) == 0) {
      out.println("해당 번호의 펫이 없습니다.");
    } else {
      out.println("펫을 삭제하였습니다.");
    }

    return ""; // 체크
  }
}
