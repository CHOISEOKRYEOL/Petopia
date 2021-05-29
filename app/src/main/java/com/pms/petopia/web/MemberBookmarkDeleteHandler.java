package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.service.BookmarkService;

@Controller
public class MemberBookmarkDeleteHandler {

  BookmarkService bookmarkService;

  public MemberBookmarkDeleteHandler(BookmarkService bookmarkService) {
    this.bookmarkService = bookmarkService;
  }

  @RequestMapping("/member/bookmarkdelete")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    int hno = Integer.parseInt(request.getParameter("hno"));


    bookmarkService.delete(no);

    if(hno == -1) {
      return "redirect:../hospital/list";
    }
    else if(hno == 0){
      return "redirect:bookmarklist";
    }
    else {
      return "redirect:../hospital/detail?no=" + hno;
    }

  }
}
