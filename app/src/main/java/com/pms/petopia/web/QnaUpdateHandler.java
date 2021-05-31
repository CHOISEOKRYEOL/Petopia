package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.service.QnaService;

@Controller
public class QnaUpdateHandler {

  QnaService qnaService;

  public QnaUpdateHandler(QnaService qnaService) {
    this.qnaService = qnaService;
  }

  @RequestMapping("/qna/update")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    if(request.getMethod().equals("GET")) {
      int no = Integer.parseInt(request.getParameter("no"));
      Qna q = qnaService.get(no);
      request.setAttribute("qna", q);
      return "/jsp/qna/modifying_form.jsp";
    }

    Qna qna = new Qna();
    qna.setNo(Integer.parseInt(request.getParameter("no")));
    qna.setTitle(request.getParameter("title"));
    qna.setContent(request.getParameter("content"));
    qnaService.update(qna);

    return "/jsp/qna/update.jsp";
    //    response.setHeader("Refresh", "1;url=list");
  }
}
