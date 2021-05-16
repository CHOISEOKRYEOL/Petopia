package com.pms.petopia.web.listener;

import java.io.InputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.pms.mybatis.MybatisDaoFactory;
import com.pms.mybatis.SqlSessionFactoryProxy;
import com.pms.petopia.dao.BigAddressDao;
import com.pms.petopia.dao.HospitalDao;
import com.pms.petopia.dao.MemberDao;
import com.pms.petopia.dao.MyTownBoardCommentDao;
import com.pms.petopia.dao.MyTownBoardDao;
import com.pms.petopia.dao.PetDao;
import com.pms.petopia.dao.QnaDao;
import com.pms.petopia.dao.RecordDao;
import com.pms.petopia.dao.ReviewDao;
import com.pms.petopia.dao.SharingMarketBoardDao;
import com.pms.petopia.dao.SmallAddressDao;
import com.pms.petopia.dao.StoryDao;
import com.pms.petopia.service.BigAddressService;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.MemberService;
import com.pms.petopia.service.MyTownBoardCommentService;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.PetService;
import com.pms.petopia.service.QnaService;
import com.pms.petopia.service.RecordService;
import com.pms.petopia.service.ReviewService;
import com.pms.petopia.service.SharingMarketBoardService;
import com.pms.petopia.service.SmallAddressService;
import com.pms.petopia.service.StoryService;
import com.pms.petopia.service.impl.DefaultBigAddressService;
import com.pms.petopia.service.impl.DefaultHospitalService;
import com.pms.petopia.service.impl.DefaultMemberService;
import com.pms.petopia.service.impl.DefaultMyTownBoardCommentService;
import com.pms.petopia.service.impl.DefaultMyTownBoardService;
import com.pms.petopia.service.impl.DefaultPetService;
import com.pms.petopia.service.impl.DefaultQnaService;
import com.pms.petopia.service.impl.DefaultRecordService;
import com.pms.petopia.service.impl.DefaultReviewService;
import com.pms.petopia.service.impl.DefaultSharingMarketBoardService;
import com.pms.petopia.service.impl.DefaultSmallAddressService;
import com.pms.petopia.service.impl.DefaultStorylService;

// 웹 애플리케이션을 시작하거나 종료할 때 서버로부터 보고를 받는다.
// 즉, 톰캣 서버가 웹 애플리케이션을 시작하면, Listener 규칙에 따라 메소드를 호출한다는 뜻이다.
// 
public class ContextLoaderListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    try {

      ServletContext servletContext = sce.getServletContext();

      // 1) Mybatis 관련 객체 준비
      InputStream mybatisConfigStream = Resources.getResourceAsStream(
          servletContext.getInitParameter("mybatis-config"));
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
      MyTownBoardCommentDao myTownBoardCommentDao = daoFactory.createDao(MyTownBoardCommentDao.class);
      SharingMarketBoardDao sharingMarketBoardDao = daoFactory.createDao(SharingMarketBoardDao.class);
      BigAddressDao bigAddressDao = daoFactory.createDao(BigAddressDao.class);
      SmallAddressDao smallAddressDao = daoFactory.createDao(SmallAddressDao.class);
      ReviewDao reviewDao = daoFactory.createDao(ReviewDao.class);
      QnaDao qnaDao = daoFactory.createDao(QnaDao.class);

      // 3) 서비스 관련 객체 준비
      MemberService memberService = new DefaultMemberService(memberDao);
      PetService petService = new DefaultPetService(petDao);
      RecordService recordService = new DefaultRecordService(recordDao);
      HospitalService hospitalService = new DefaultHospitalService(hospitalDao);
      StoryService storyService = new DefaultStorylService(storyDao);
      MyTownBoardService myTownBoardService = new DefaultMyTownBoardService(myTownBoardDao);
      MyTownBoardCommentService myTownBoardCommentService = new DefaultMyTownBoardCommentService(myTownBoardCommentDao);
      SharingMarketBoardService sharingMarketBoardService = new DefaultSharingMarketBoardService(sharingMarketBoardDao);
      BigAddressService bigAddressService = new DefaultBigAddressService(bigAddressDao);
      SmallAddressService smallAddressService = new DefaultSmallAddressService(smallAddressDao);
      ReviewService reviewService = new DefaultReviewService(reviewDao);
      QnaService qnaService = new DefaultQnaService(qnaDao);

      // 4) 서비스 객체를 ServletContext 보관소에 저장한다.
      servletContext.setAttribute("memberService", memberService);
      servletContext.setAttribute("petService", petService);
      servletContext.setAttribute("recordService", recordService);
      servletContext.setAttribute("hospitalService", hospitalService);
      servletContext.setAttribute("storyService", storyService);
      servletContext.setAttribute("myTownBoardService", myTownBoardService);
      servletContext.setAttribute("myTownBoardCommentService", myTownBoardCommentService);
      servletContext.setAttribute("sharingMarketBoardService", sharingMarketBoardService);
      servletContext.setAttribute("bigAddressService", bigAddressService);
      servletContext.setAttribute("smallAddressService", smallAddressService);
      servletContext.setAttribute("reviewService", reviewService);
      servletContext.setAttribute("qnaService", qnaService);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
