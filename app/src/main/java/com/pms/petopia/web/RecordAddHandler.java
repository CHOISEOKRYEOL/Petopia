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
import com.pms.petopia.service.PetService;
import com.pms.petopia.service.RecordService;

@SuppressWarnings("serial")
@WebServlet("/record/add")
public class RecordAddHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/jsp/record/form.jsp").include(request, response);;
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RecordService recordService = (RecordService) request.getServletContext().getAttribute("recordService");
    HospitalService hospitalService = (HospitalService) request.getServletContext().getAttribute("hospitalService");
    PetService petService = (PetService) request.getServletContext().getAttribute("petService");

    try {
      Record r = new Record();
      //      r.setState(Integer.parseInt(request.getParameter("state")));
      //      r.setRecord(request.getParameter("record"));

      Pet petNo = (Pet) request.getSession().getAttribute("petNo");
      r.setPetNo(petNo);

      Hospital hospital = (Hospital) request.getSession().getAttribute("hospital");
      r.setHospitalNo(hospital);

      recordService.add(r);

      response.setHeader("Refresh", "1;url=../main");

    } catch (Exception e) {
      throw new ServletException(e);
    }
    //
  }

}
