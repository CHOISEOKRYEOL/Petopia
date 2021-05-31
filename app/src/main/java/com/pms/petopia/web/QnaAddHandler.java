package com.pms.petopia.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.service.QnaService;

@Controller
public class QnaAddHandler {

  QnaService qnaService;

  public QnaAddHandler(QnaService qnaService) {
    this.qnaService = qnaService;
  }

  @RequestMapping("/qna/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    if(request.getMethod().equals("GET")) {
      return "/jsp/qna/qna_form.jsp";
    }

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    if(loginUser == null) {
      throw new ServletException("로그인 후 이용하세요.");
    }

    Qna qna = new Qna();
    qna.setTitle(request.getParameter("title"));
    qna.setContent(request.getParameter("content"));
    qna.setWriter(loginUser);

    qnaService.add(qna);


    return "/jsp/qna/qna_add_success.jsp";
    //    response.setHeader("Refresh", "1;url=list");
  }
}
