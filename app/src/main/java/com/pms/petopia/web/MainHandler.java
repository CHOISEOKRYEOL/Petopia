package com.pms.petopia.web;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.Story;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.StoryService;

@Controller
public class MainHandler {

  MyTownBoardService myTownBoardService;
  StoryService storyService;

  public MainHandler(MyTownBoardService myTownBoardService, StoryService storyService) {
    this.myTownBoardService = myTownBoardService;
    this.storyService = storyService;
  }

  @RequestMapping("/main")
  public void execute(Model model)throws Exception {

    List<MyTownBoard> myTownList = myTownBoardService.listAll();
    List<Story> storyList = storyService.list();

    model.addAttribute("myTownList", myTownList);
    model.addAttribute("storyList", storyList);

  }

}