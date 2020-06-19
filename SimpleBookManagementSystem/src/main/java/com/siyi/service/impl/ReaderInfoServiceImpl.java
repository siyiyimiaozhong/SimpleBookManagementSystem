package com.siyi.service.impl;

import com.siyi.dao.ReaderInfoDAO;
import com.siyi.domain.ReaderInfo;
import com.siyi.service.ReaderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReaderInfoServiceImpl implements ReaderInfoService {

    @Autowired
    private ReaderInfoDAO readerInfoDAO;

    public ReaderInfo checkLogin(String username, String password) {
        ReaderInfo readerInfo = readerInfoDAO.findReaderByUsername(username);
        if(readerInfo!=null && password.equals(readerInfo.getPassword())){
            return readerInfo;
        }
        return null;
    }

    public boolean addReader(ReaderInfo readerInfo) {
        readerInfo.setBorrowCount(0L);
        readerInfo.setCreateTime(new Date());
        int i = readerInfoDAO.saveReader(readerInfo);
        if(i==1){
            return true;
        }
        return false;
    }
}
