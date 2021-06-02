package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Bookmark;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.BookmarkService;

@Controller
@RequestMapping("/bookmark")
public class BookmarkController {

  BookmarkService bookmarkService;

  public BookmarkController(BookmarkService bookmarkService) {
    this.bookmarkService = bookmarkService;
  }

  @PostMapping("add")
  public void add(HttpServletRequest request)
      throws Exception {

    Bookmark b = new Bookmark();

    Member m = new Member();
    int mno = Integer.parseInt(request.getParameter("mno"));
    m.setNo(mno);

    Hospital h = new Hospital();
    int hno = Integer.parseInt(request.getParameter("hno"));
    h.setNo(hno);

    b.setMember(m);
    b.setHospital(h);

    bookmarkService.add(b);


    //    if(check == 0) {
    //      return "redirect:../hospital/detail?no=" + h.getNo();
    //    }
    //    else {
    //      return "redirect:../hospital/list";
    //    }
  }

  @GetMapping("delete")
  public void delete(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    bookmarkService.delete(no);


    //    if(hno == -1) {
    //      return "redirect:../hospital/list";
    //    }
    //    else if(hno == 0){
    //      return "redirect:list";
    //    }
    //    else {
    //      return "redirect:../hospital/detail?no=" + hno;
    //    }
  }

  @GetMapping("list")
  public void list(HttpSession session, Model model)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

    List<Bookmark> list = bookmarkService.list(loginUser.getNo());

    model.addAttribute("list", list);

  }

}
