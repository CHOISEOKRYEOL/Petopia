package com.pms.petopia.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.service.QnaService;

@Controller
public class QnaDetailHandler {

  QnaService qnaService;

  public QnaDetailHandler(QnaService qnaService) {
    this.qnaService = qnaService;
  }

  @RequestMapping("/qna/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Qna q = qnaService.get(no);
    request.setAttribute("qna", q);

    return "/jsp/qna/detail.jsp";

  }
}
