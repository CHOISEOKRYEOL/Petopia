package com.pms.petopia.web;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.service.MyTownBoardService;

@Controller
public class MainHandler {

  MyTownBoardService myTownBoardService;

  public MainHandler(MyTownBoardService myTownBoardService) {
    this.myTownBoardService = myTownBoardService;
  }

  @RequestMapping("/main")
  public void execute(Model model)throws Exception {

    List<MyTownBoard> myTownList = myTownBoardService.listAll();

    model.addAttribute("myTownList", myTownList);

  }

}