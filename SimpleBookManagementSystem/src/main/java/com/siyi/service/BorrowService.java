package com.siyi.service;

import com.siyi.domain.Borrow;
import com.siyi.vo.PageResult;

import java.util.List;

public interface BorrowService {
    List<Borrow> findAllByOverdue(String key, String value);

    int updateBackDate(String id);

    boolean updateBackDateByIds(String[] idArray);

    PageResult<Borrow> findAllByNotReturn(String key, String value, Integer page, Integer rows);

    PageResult<Borrow> findAll(String key, String value, Integer page, Integer rows);
}
