package com.siyi.service;

import com.siyi.domain.ReaderInfo;

public interface ReaderInfoService {
    ReaderInfo checkLogin(String username, String password);

    boolean addReader(ReaderInfo readerInfo);

}
