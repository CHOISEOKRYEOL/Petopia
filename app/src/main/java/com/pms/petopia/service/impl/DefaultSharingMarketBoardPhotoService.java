package com.pms.petopia.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.pms.petopia.dao.SharingMarketBoardPhotoDao;
import com.pms.petopia.domain.SharingMarketBoardPhoto;
import com.pms.petopia.service.SharingMarketBoardPhotoService;
@Service
public class DefaultSharingMarketBoardPhotoService implements SharingMarketBoardPhotoService{

  SharingMarketBoardPhotoDao sharingMarketBoardPhotoDao;
  public DefaultSharingMarketBoardPhotoService(SharingMarketBoardPhotoDao sharingMarketBoardPhotoDao){
    this.sharingMarketBoardPhotoDao = sharingMarketBoardPhotoDao;
  }

  @Override
  public int add(SharingMarketBoardPhoto phot) throws Exception {
    return sharingMarketBoardPhotoDao.insert(phot);
  }

  @Override
  public int update(SharingMarketBoardPhoto phot) throws Exception {
    return sharingMarketBoardPhotoDao.update(phot);
  }

  @Override
  public List<SharingMarketBoardPhoto> list(int boardNo) throws Exception {
    return sharingMarketBoardPhotoDao.findAll(boardNo);
  }

  @Override
  public int delete(int no) throws Exception {
    return sharingMarketBoardPhotoDao.delete(no);
  }

  @Override
  public SharingMarketBoardPhoto get(int no) throws Exception {
    return sharingMarketBoardPhotoDao.findByNo(no);
  }



}
