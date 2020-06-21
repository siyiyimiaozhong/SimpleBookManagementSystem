package com.siyi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.siyi.dao.ReaderInfoDAO;
import com.siyi.domain.BookInfo;
import com.siyi.domain.ReaderInfo;
import com.siyi.service.ReaderInfoService;
import com.siyi.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReaderInfoServiceImpl implements ReaderInfoService {

    @Autowired
    private ReaderInfoDAO readerInfoDAO;

    /**
     * 验证登录信息
     * @param username
     * @param password
     * @return
     */
    public ReaderInfo checkLogin(String username, String password) {
        ReaderInfo readerInfo = readerInfoDAO.findReaderByUsername(username);
        if(readerInfo!=null && password.equals(readerInfo.getPassword())){
            return readerInfo;
        }
        return null;
    }

    /**
     * 添加读者信息
     * @param readerInfo
     * @return
     */
    public boolean addReader(ReaderInfo readerInfo) {
        readerInfo.setBorrowCount(0L);
        readerInfo.setCreateTime(new Date());
        int i = readerInfoDAO.saveReader(readerInfo);
        if(i==1){
            return true;
        }
        return false;
    }

    /**
     * 分页查询相应读者
     * @param key
     * @param page
     * @param rows
     * @return
     */
    public PageResult<ReaderInfo> findAll(String key, Integer page, Integer rows) {
        List<ReaderInfo> readers;
        if(key!=null && key.length()!=0){
            key="%"+key+"%";
            PageHelper.startPage(page,rows);
            readers = readerInfoDAO.findReadersByKey(key);
        }else{
            PageHelper.startPage(page,rows);
            readers = readerInfoDAO.findAll();
        }
        PageInfo<ReaderInfo> pageInfo = new PageInfo<ReaderInfo>(readers);
        return new PageResult<ReaderInfo>((int)pageInfo.getTotal(),pageInfo.getPages(),readers);
    }

    /**
     * 修改读者信息
     * @param readerInfo
     * @return
     */
    public int updateReader(ReaderInfo readerInfo) {
        return readerInfoDAO.updateReader(readerInfo);
    }

    /**
     * 根据id查询读者
     * @param id
     * @return
     */
    public ReaderInfo findReaderById(Long id) {
        return readerInfoDAO.findReaderById(id);
    }

    /**
     * 根据id删除读者
     * @param id
     * @return
     */
    public int deleteReaderById(Long id) {
        return readerInfoDAO.deleteReaderById(id);
    }

    /**
     * 根据ids数组批量删除读者
     * @param ids
     * @return
     */
    public boolean deleteReaders(String[] ids) {
        for(String id:ids){
            if(readerInfoDAO.deleteReaderById(Long.parseLong(id))!=1){
                return false;
            }
        }
        return true;
    }
}
