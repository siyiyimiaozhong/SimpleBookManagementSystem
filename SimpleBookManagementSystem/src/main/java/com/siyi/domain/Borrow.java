package com.siyi.domain;

import java.io.Serializable;
import java.util.Date;

public class Borrow implements Serializable {
    private String borrowId;
    private String bookName;
    private String readerName;
    private Date lendDate;//借出时间
    private Date backDate;//归还时间

    public Borrow() {
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    public Borrow(String borrowId, String bookName, String readerName, Date lendDate, Date backDate) {
        this.borrowId = borrowId;
        this.bookName = bookName;
        this.readerName = readerName;
        this.lendDate = lendDate;
        this.backDate = backDate;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowId='" + borrowId + '\'' +
                ", bookName='" + bookName + '\'' +
                ", readerName='" + readerName + '\'' +
                ", lendDate=" + lendDate +
                ", backDate=" + backDate +
                '}';
    }
}
