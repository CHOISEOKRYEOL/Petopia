package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.service.QnaService;

@Controller
public class AdminQnaDetailHandler {

  QnaService qnaService;

  public AdminQnaDetailHandler(QnaService qnaService) {
    this.qnaService = qnaService;
  }

  @RequestMapping("/admin/qnadetail")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Qna q = qnaService.get(no);
    request.setAttribute("qna", q);

    return "/jsp/admin/qna_detail.jsp";

  }
}
