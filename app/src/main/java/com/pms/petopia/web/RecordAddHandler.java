package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.domain.Record;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.RecordService;

@SuppressWarnings("serial")
@WebServlet("/record/add")
public class RecordAddHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/jsp/record/form.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RecordService recordService = (RecordService) request.getServletContext().getAttribute("recordService");
    HospitalService hospitalService = (HospitalService) request.getServletContext().getAttribute("hospitalService");

    Pet petInfo = (Pet) request.getSession().getAttribute("petInfo");

    try {
      Record r = new Record();
      Hospital h = hospitalService.get(Integer.parseInt(request.getParameter("no")));

      r.setState(Integer.parseInt(request.getParameter("state")));
      r.setRecord(request.getParameter("record"));
      // 로딩해야 할 값 : / 펫 정보 / 병원 정보
      r.setPetNo(petInfo);



      r.setHospitalNo(h);


      System.out.println(r);
      recordService.add(r);

      response.setHeader("Refresh", "1;url=../main");

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }

}
