package com.siyi.service.impl;

import com.siyi.dao.AdminDAO;
import com.siyi.domain.Admin;
import com.siyi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDAO adminDAO;

    public Admin checkLogin(String username, String password) {
        Admin admin = adminDAO.findAdminByUsername(username);
        if(admin!=null && password.equals(admin.getPassword())){
            return admin;
        }
        return null;
    }
}
