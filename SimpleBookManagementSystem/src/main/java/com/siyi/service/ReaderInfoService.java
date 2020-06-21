package com.siyi.service;

import com.siyi.domain.ReaderInfo;
import com.siyi.vo.PageResult;

public interface ReaderInfoService {
    ReaderInfo checkLogin(String username, String password);

    boolean addReader(ReaderInfo readerInfo);

    PageResult<ReaderInfo> findAll(String key, Integer page, Integer rows);

    int updateReader(ReaderInfo readerInfo);

    ReaderInfo findReaderById(Long id);

    int deleteReaderById(Long id);

    boolean deleteReaders(String[] ids);
}
