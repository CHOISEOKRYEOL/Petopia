package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainHandler {

  @RequestMapping("/main")
  public void execute()
      throws ServletException, IOException {

  }
}