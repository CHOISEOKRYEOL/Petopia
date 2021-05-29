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
public class AdminQnaListHandler {

  QnaService qnaService;

  public AdminQnaListHandler(QnaService qnaService) {
    this.qnaService = qnaService;
  }

  @RequestMapping("/admin/qnalist")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if(loginUser.getRole() == 1) {
      return "/jsp/admin/access_fail.jsp";
      //      response.setHeader("Refresh", "1;url=../main");
    }
    else {
      List<Qna> list = qnaService.list();

      request.setAttribute("list", list);

      return "/jsp/admin/qna_list.jsp";
    }
  }

}
