package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.service.QnaService;

@Controller
public class QnaListHandler {

  QnaService qnaService;

  public QnaListHandler(QnaService qnaService) {
    this.qnaService = qnaService;
  }

  @RequestMapping("/qna/list")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    Member loginUser = (Member) request.getServletContext().getAttribute("loginUser");

    List<Qna> list = qnaService.list();

    request.setAttribute("loginUser", loginUser);
    request.setAttribute("list", list);

    return "/jsp/qna/list.jsp";

  }
}
