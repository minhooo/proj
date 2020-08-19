package com.example.demo.entity;

import java.util.Date;

public class Board {
    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;

    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getBoardNo() {
        return boardNo;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public Date getRegDate() {
        return regDate;
    }
}
