package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.SmallAddressService;

@Controller
public class AdminHospitalListHandler {

  HospitalService hospitalService;
  SmallAddressService smallAddressService;

  public AdminHospitalListHandler(HospitalService hospitalService, SmallAddressService smallAddressService) {
    this.hospitalService = hospitalService;
    this.smallAddressService = smallAddressService;
  }

  @RequestMapping("/admin/hospitallist")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<Hospital> hospitals = hospitalService.list();
    List<SmallAddress> area = smallAddressService.list();

    request.setAttribute("list", hospitals);
    request.setAttribute("area", area);

    return "/jsp/admin/hospital_list.jsp";

  }
}
