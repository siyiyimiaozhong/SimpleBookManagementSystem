package com.siyi.service;

import com.siyi.domain.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow> findAllByOverdue(String key, String value);

    int updateBackDate(String id);

    boolean updateBackDateByIds(String[] idArray);

}
