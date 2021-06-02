package com.pms.petopia.web;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
  public String add(SharingMarketBoardComment smbComt,String content,HttpSession session, HttpServletResponse response) throws Exception {


    PrintWriter out = response.getWriter();

    SharingMarketBoard oldBoard = sharingMarketBoardService.get(smbComt.getNo());
    smbComt.setSharingmarketboard(oldBoard);
    if(content=="") {
      out.print("empty");
    }
    smbComt.setContent(content);

    Member loginUser = (Member)session.getAttribute("loginUser");
    smbComt.setWriter(loginUser);
    sharingMarketBoardCommentService.add(smbComt);

    String webAdress= String.format("../sharingmarketboard/detail?no=%d", 
        oldBoard.getNo());

    return "redirect:" + webAdress;
  }

  @GetMapping("delete")
  public String delete(int no, HttpServletResponse response) throws Exception {

    SharingMarketBoard oldBoard = sharingMarketBoardService.get(no);
    PrintWriter out = response.getWriter();
    out.print("working");
    sharingMarketBoardCommentService.delete(no);

    String webAdress= String.format("../sharingmarketboard/detail?no=%d",oldBoard.getNo());
    return "redirect:" + webAdress;

  }

  @PostMapping("update")
  public String update(HttpSession session,String content,
      SharingMarketBoardComment smbComt, HttpServletResponse response) throws Exception {

    SharingMarketBoard oldBoard = sharingMarketBoardService.get(smbComt.getNo());

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("변경 권한이 없습니다!");
    }

    SharingMarketBoardComment oldSmbComt = sharingMarketBoardCommentService.getNo(smbComt.getNo());

    smbComt.setNo(oldSmbComt.getNo());
    smbComt.setSharingmarketboard(oldBoard);
    smbComt.setContent(content);
    sharingMarketBoardCommentService.update(smbComt);

    String webAdress= String.format("../sharingmarketboard/detail?no=%d",oldBoard.getNo());
    return "redirect:" + webAdress;

  }

}
