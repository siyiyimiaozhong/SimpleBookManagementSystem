package com.siyi.domain;

import java.io.Serializable;
import java.util.Date;

public class Borrow implements Serializable {
    private String borrowId;
    private Long bookId;
    private Long readerId;
    private Date lendDate;//借出时间
    private Date backDate;//归还时间

    public Borrow() {
    }

    public Borrow(String borrowId, Long bookId, Long readerId, Date lendDate, Date backDate) {
        this.borrowId = borrowId;
        this.bookId = bookId;
        this.readerId = readerId;
        this.lendDate = lendDate;
        this.backDate = backDate;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
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

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowId='" + borrowId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", readerId='" + readerId + '\'' +
                ", lendDate=" + lendDate +
                ", backDate=" + backDate +
                '}';
    }
}
