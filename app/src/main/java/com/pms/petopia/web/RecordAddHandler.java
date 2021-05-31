package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.domain.Record;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.PetService;
import com.pms.petopia.service.RecordService;

@Controller
public class RecordAddHandler {

  RecordService recordService;
  HospitalService hospitalService;
  PetService petService;

  public RecordAddHandler(RecordService recordService, HospitalService hospitalService, PetService petService) {
    this.recordService = recordService;
    this.hospitalService = hospitalService;
    this.petService = petService;
  }  

  @RequestMapping("/record/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    if(request.getMethod().equals("GET")) {

      return "/jsp/record/form.jsp";
    }
    Record r = new Record();
    r.setRecord(request.getParameter("record"));

    Pet petNo = (Pet) request.getSession().getAttribute("petNo");
    r.setPetNo(petNo);

    Hospital hospital = (Hospital) request.getSession().getAttribute("hospital");
    r.setHospitalNo(hospital);

    recordService.add(r);

    return "../main";
    //            response.setHeader("Refresh", "1;url=../main");
  }
}
