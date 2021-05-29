package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Bookmark;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.BookmarkService;

@Controller
public class MemberBookmarkAddHandler {

  BookmarkService bookmarkService;

  public MemberBookmarkAddHandler(BookmarkService bookmarkService) {
    this.bookmarkService = bookmarkService;
  }

  @RequestMapping("/member/bookmarkadd")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Bookmark b = new Bookmark();

    Member m = new Member();
    m.setNo(Integer.parseInt(request.getParameter("mno")));

    Hospital h = new Hospital();
    h.setNo(Integer.parseInt(request.getParameter("hno")));

    b.setMember(m);
    b.setHospital(h);

    int check = Integer.parseInt(request.getParameter("hiddenNo"));


    bookmarkService.add(b);

    if(check == 0) {
      return "redirect:../hospital/detail?no=" + h.getNo();
    }
    else {
      return "redirect:../hospital/list";
    }

  }

}
