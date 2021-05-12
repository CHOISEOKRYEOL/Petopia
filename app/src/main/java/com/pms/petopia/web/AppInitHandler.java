package com.pms.petopia.web;

import java.io.InputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.pms.mybatis.MybatisDaoFactory;
import com.pms.mybatis.SqlSessionFactoryProxy;
import com.pms.petopia.dao.BigAddressDao;
import com.pms.petopia.dao.HospitalDao;
import com.pms.petopia.dao.MemberDao;
import com.pms.petopia.dao.MyTownBoardDao;
import com.pms.petopia.dao.PetDao;
import com.pms.petopia.dao.RecordDao;
import com.pms.petopia.dao.ReviewDao;
import com.pms.petopia.dao.SharingMarketBoardDao;
import com.pms.petopia.dao.SmallAddressDao;
import com.pms.petopia.dao.StoryDao;
import com.pms.petopia.service.BigAddressService;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.MemberService;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.PetService;
import com.pms.petopia.service.RecordService;
import com.pms.petopia.service.ReviewService;
import com.pms.petopia.service.SharingMarketBoardService;
import com.pms.petopia.service.SmallAddressService;
import com.pms.petopia.service.StoryService;
import com.pms.petopia.service.impl.DefaultBigAddressService;
import com.pms.petopia.service.impl.DefaultHospitalService;
import com.pms.petopia.service.impl.DefaultMemberService;
import com.pms.petopia.service.impl.DefaultMyTownBoardService;
import com.pms.petopia.service.impl.DefaultPetService;
import com.pms.petopia.service.impl.DefaultRecordService;
import com.pms.petopia.service.impl.DefaultReviewService;
import com.pms.petopia.service.impl.DefaultSharingMarketBoardService;
import com.pms.petopia.service.impl.DefaultSmallAddressService;
import com.pms.petopia.service.impl.DefaultStorylService;

//@WebServlet(
//    value="/init",   // 클라인언트에서 요청할 때 사용할 명령이다.
//    loadOnStartup = 1 // 톰캣 서버를 실행할 때 이 객체를 생성하라고 지정한다.
//    )
// loadOnStartup 이 지정되지 않은 경우, 
// 클라이언트가 실행을 요청할 때 서블릿 객체를 생성한다.
// 물론 한 번 객체를 생성하면 그 생성된 객체를 계속 사용한다.
// 즉 두 개의 객체를 생성하진 않는다.
@SuppressWarnings("serial")
public class AppInitHandler extends HttpServlet {

  @Override
  public void init() throws ServletException {
    // 서블릿 객체를 생성할 때 톰캣 서버가 호출하는 메서드
    // => 보통 서블릿들이 사용할 의존 객체를 준비하는 등의 일을 한다.

    try {
      // 1) Mybatis 관련 객체 준비
      InputStream mybatisConfigStream = Resources.getResourceAsStream(
          this.getInitParameter("mybatis-config"));
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfigStream);
      SqlSessionFactoryProxy sqlSessionFactoryProxy = new SqlSessionFactoryProxy(sqlSessionFactory);

      // 2) DAO 관련 객체 준비
      MybatisDaoFactory daoFactory = new MybatisDaoFactory(sqlSessionFactoryProxy);

      MemberDao memberDao = daoFactory.createDao(MemberDao.class);
      PetDao petDao = daoFactory.createDao(PetDao.class);
      RecordDao recordDao = daoFactory.createDao(RecordDao.class);
      HospitalDao hospitalDao = daoFactory.createDao(HospitalDao.class);
      StoryDao storyDao = daoFactory.createDao(StoryDao.class);
      MyTownBoardDao myTownBoardDao = daoFactory.createDao(MyTownBoardDao.class);
      SharingMarketBoardDao sharingMarketBoardDao = daoFactory.createDao(SharingMarketBoardDao.class);
      BigAddressDao bigAddressDao = daoFactory.createDao(BigAddressDao.class);
      SmallAddressDao smallAddressDao = daoFactory.createDao(SmallAddressDao.class);
      ReviewDao reviewDao = daoFactory.createDao(ReviewDao.class);
      // 3) 서비스 관련 객체 준비
      //      TransactionManager txManager = new TransactionManager(sqlSessionFactoryProxy);

      MemberService memberService = new DefaultMemberService(memberDao);
      PetService petService = new DefaultPetService(petDao);
      RecordService recordService = new DefaultRecordService(recordDao);
      HospitalService hospitalService = new DefaultHospitalService(hospitalDao);
      StoryService storyService = new DefaultStorylService(storyDao);
      MyTownBoardService myTownBoardService = new DefaultMyTownBoardService(myTownBoardDao);
      SharingMarketBoardService sharingMarketBoardService = new DefaultSharingMarketBoardService(sharingMarketBoardDao);
      BigAddressService bigAddressService = new DefaultBigAddressService(bigAddressDao);
      SmallAddressService smallAddressService = new DefaultSmallAddressService(smallAddressDao);
      ReviewService reviewService = new DefaultReviewService(reviewDao);

      // 4) 서비스 객체를 ServletContext 보관소에 저장한다.
      ServletContext servletContext = this.getServletContext();

      servletContext.setAttribute("memberService", memberService);
      servletContext.setAttribute("petService", petService);
      servletContext.setAttribute("recordService", recordService);
      servletContext.setAttribute("hospitalService", hospitalService);
      servletContext.setAttribute("storyService", storyService);
      servletContext.setAttribute("myTownBoardService", myTownBoardService);
      servletContext.setAttribute("sharingMarketBoardService", sharingMarketBoardService);
      servletContext.setAttribute("bigAddressService", bigAddressService);
      servletContext.setAttribute("smallAddressService", smallAddressService);
      servletContext.setAttribute("reviewService", reviewService);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
