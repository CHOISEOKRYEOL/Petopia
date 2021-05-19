package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.domain.Record;
import com.pms.petopia.service.RecordService;

@SuppressWarnings("serial")
@WebServlet("/record/add")
public class RecordAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RecordService recordService = (RecordService) request.getServletContext().getAttribute("recordService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>진료기록 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>진료기록 등록</h1>");

    try {

      Record r = new Record();
      r.setState(Integer.parseInt(request.getParameter("state")));
      r.setRecord(request.getParameter("record"));

      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      r.setOwner(loginUser);

      Pet pet = (Pet) request.getSession().getAttribute("pet");
      r.setPetNo(pet);

      Hospital hospital = (Hospital) request.getSession().getAttribute("hospital");
      r.setHospitalNo(hospital);



      //      Hospital hospital = new Hospital();
      //      int hospitalNo = hospital.getNo();  
      //
      //      Pet pet = new Pet();
      //      int petNo = pet.getNo();

      //      request.getSession().setAttribute("hospital", hospitalNo);
      //      request.getSession().setAttribute("pet" ,petNo);
      //
      //      System.out.println(hospitalNo);
      //      System.out.println(petNo);

      System.out.println(r);
      recordService.add(r);

      out.println("<p>진료기록을 등록했습니다.</p>");
      response.setHeader("Refresh", "1;url=../main");

    } catch (Exception e) {
      throw new ServletException(e);
    }

    out.println("</body>");
    out.println("</html>");
  }

}
