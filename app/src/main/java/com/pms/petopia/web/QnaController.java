package com.pms.petopia.web;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.service.QnaService;

@Controller
@RequestMapping("/qna")
public class QnaController {

  QnaService qnaService;

  public QnaController(QnaService qnaService) {
    this.qnaService = qnaService;
  }

  @RequestMapping("add")
  public String add(HttpServletRequest request, HttpServletResponse response)
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

  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
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


  @RequestMapping("detail")
  public String detail(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Qna q = qnaService.get(no);
    request.setAttribute("qna", q);

    return "/jsp/qna/detail.jsp";

  }


  @RequestMapping("list")
  public String list(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    Member loginUser = (Member) request.getServletContext().getAttribute("loginUser");

    List<Qna> list = qnaService.list();

    request.setAttribute("loginUser", loginUser);
    request.setAttribute("list", list);

    return "/jsp/qna/list.jsp";

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
