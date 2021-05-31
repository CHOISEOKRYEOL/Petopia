package com.pms.petopia.web;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @GetMapping("qna_form")
  public void form() throws Exception {

  }

  @PostMapping("add")
  public String add(Qna qna, HttpSession session)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

    if(loginUser == null) {
      throw new ServletException("로그인 후 이용 가능합니다.");
    }

    qna.setWriter(loginUser);

    qnaService.add(qna);

    return "qna/qna_add_success";
  }

  @GetMapping("delete")
  public String delete(int no, HttpServletRequest request, HttpSession session) throws Exception {
    Member loginUser = (Member) session.getAttribute("loginUser");

    qnaService.delete(no);

    if(loginUser.getRole() == 0) {
      return "redirect:../admin/qnalist";
    }
    else {
      return "redirect:list";
    }
  }


  @GetMapping("detail")
  public void detail(int no, Model model)
      throws Exception {

    Qna q = qnaService.get(no);
    model.addAttribute("qna", q);

  }


  @GetMapping("list")
  public void list(HttpSession session, Model model)
      throws Exception {
    Member loginUser = (Member) session.getAttribute("loginUser");

    List<Qna> list = qnaService.list();

    model.addAttribute("loginUser", loginUser);
    model.addAttribute("list", list);

  }

  @GetMapping("modifying_form")
  public void modifyingForm(int no, Model model) throws Exception {
    Qna q = qnaService.get(no);
    model.addAttribute("qna", q);
  }


  @PostMapping("update")
  public void execute(Qna qna)
      throws Exception {

    qnaService.update(qna);
  }


















}
