package com.pms.petopia.web;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.domain.SharingMarketBoardComment;
import com.pms.petopia.service.SharingMarketBoardCommentService;
import com.pms.petopia.service.SharingMarketBoardService;

@Controller
@RequestMapping("/sharingmarketboardcomment")
public class SharingMarketBoardCommentController{
  SharingMarketBoardService sharingMarketBoardService;
  SharingMarketBoardCommentService sharingMarketBoardCommentService;

  public SharingMarketBoardCommentController(SharingMarketBoardService sharingMarketBoardService, SharingMarketBoardCommentService sharingMarketBoardCommentService) {
    this.sharingMarketBoardCommentService = sharingMarketBoardCommentService;
    this.sharingMarketBoardService = sharingMarketBoardService;
  }

  @RequestMapping("add")
  public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {

    SharingMarketBoardComment smbComt = new SharingMarketBoardComment();

    PrintWriter out = response.getWriter();
    int boardNo = Integer.parseInt(request.getParameter("no"));

    SharingMarketBoard oldBoard = sharingMarketBoardService.get(boardNo);
    smbComt.setSharingmarketboard(oldBoard);
    String content = request.getParameter("content");
    if(content=="") {
      out.print("empty");
    }
    smbComt.setContent(content);

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    smbComt.setWriter(loginUser);
    sharingMarketBoardCommentService.add(smbComt);

    String webAdress= String.format("../sharingmarketboard/detail?no=%d", 
        oldBoard.getNo());

    return "redirect:" + webAdress;
  }

  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    SharingMarketBoardCommentService sharingMarketBoardCommentService = (SharingMarketBoardCommentService)request.getServletContext().getAttribute("sharingMarketBoardCommentService");

    int no = Integer.parseInt(request.getParameter("no"));
    SharingMarketBoard oldBoard = sharingMarketBoardService.get(no);
    System.out.println(no);
    PrintWriter out = response.getWriter();
    out.print("working");
    sharingMarketBoardCommentService.delete(no);

    String webAdress= String.format("../sharingmarketboard/detail?no=%d",oldBoard.getNo());
    return "redirect:" + webAdress;

  }

  @RequestMapping("update")
  public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {

    PrintWriter out = response.getWriter();
    response.setContentType("text/html;charset=UTF-8");
    int no = Integer.parseInt(request.getParameter("no"));
    SharingMarketBoard oldBoard = sharingMarketBoardService.get(no);

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("변경 권한이 없습니다!");
    }

    SharingMarketBoardComment oldSmbComt = sharingMarketBoardCommentService.getNo(no);
    SharingMarketBoardComment smbComt = new SharingMarketBoardComment();

    smbComt.setNo(oldSmbComt.getNo());
    smbComt.setSharingmarketboard(oldBoard);
    String content = request.getParameter("content");

    if(content == "") {
      out.print("empty");
    }else {
      out.print("working");
    }
    smbComt.setContent(content);
    sharingMarketBoardCommentService.update(smbComt);

    String webAdress= String.format("../sharingmarketboard/detail?no=%d",oldBoard.getNo());
    return "redirect:" + webAdress;

  }

}
