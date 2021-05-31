package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.QnaService;

@Controller
public class QnaDeleteHandler {

  QnaService qnaService;

  public QnaDeleteHandler(QnaService qnaService) {
    this.qnaService = qnaService;
  }

  @RequestMapping("/qna/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    int no = Integer.parseInt(request.getParameter("no"));
    qnaService.delete(no);

    if(loginUser.getRole() == 0) {
      return "redirect:../admin/qnalist";
      //      response.setHeader("Refresh", "1;url=qnalist");
    }
    else {
      return "/jsp/qna/delete.jsp";
      //      response.setHeader("Refresh", "1;url=list");
    }
  }
}
