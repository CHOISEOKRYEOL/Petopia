package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Bookmark;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.BookmarkService;

@Controller
public class MemberBookmarkListHandler {

  BookmarkService bookmarkService;

  public MemberBookmarkListHandler(BookmarkService bookmarkService) {
    this.bookmarkService = bookmarkService;
  }

  @RequestMapping("/member/bookmarklist")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    List<Bookmark> list = bookmarkService.list(loginUser.getNo());

    request.setAttribute("list", list);

    return "/jsp/member/bookmark.jsp";

  }
}
