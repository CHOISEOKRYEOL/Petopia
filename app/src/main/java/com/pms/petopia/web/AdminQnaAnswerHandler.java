package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.service.QnaService;

@Controller
public class AdminQnaAnswerHandler {

  QnaService qnaService;

  public AdminQnaAnswerHandler(QnaService qnaService) {
    this.qnaService = qnaService;
  }

  @RequestMapping("/admin/answer")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Qna qna = new Qna();
    qna.setNo(Integer.parseInt(request.getParameter("no")));
    qna.setAnswer(request.getParameter("answer"));
    qna.setState(1);
    qnaService.answer(qna);

    return "redirect:qnalist";
  }
}
