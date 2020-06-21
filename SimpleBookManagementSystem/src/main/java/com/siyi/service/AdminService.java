package com.siyi.service;

import com.siyi.domain.Admin;

public interface AdminService {
    Admin checkLogin(String username, String password);
}
