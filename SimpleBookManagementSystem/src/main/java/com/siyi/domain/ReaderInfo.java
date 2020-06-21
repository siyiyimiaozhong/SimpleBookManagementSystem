package com.siyi.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class ReaderInfo implements Serializable {
    private Long readerId;//id
    private String name;//姓名
    private String sex;//性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;//生日
    private String address;//地址
    private String phone;//电话
    private Long borrowCount;//借阅次数
    private String username;
    private String password;
    private Date createTime;

    public ReaderInfo() {
    }

    public ReaderInfo(Long readerId, String name, String sex, Date birth, String address, String phone, Long borrow_count) {
        this.readerId = readerId;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.address = address;
        this.phone = phone;
        this.borrowCount = borrow_count;
    }

    public Long getBorrowCount() {
        return borrowCount;
    }

    public void setBorrowCount(Long borrowCount) {
        this.borrowCount = borrowCount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ReaderInfo{" +
                "readerId=" + readerId +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", borrowCount=" + borrowCount +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
