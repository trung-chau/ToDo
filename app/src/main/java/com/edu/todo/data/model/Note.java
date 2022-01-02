package com.edu.todo.data.model;

public class Note {
    private int id;
    private int idUser;
    private int isDone;
    private String created;
    private String title;
    private String content;
    private int sendNotification;
    private String remainderTime;

    public Note(int id, int idUser, int isDone, String created, String title, String content, int sendNotification, String remainderTime) {
        this.id = id;
        this.idUser = idUser;
        this.isDone = isDone;
        this.created = created;
        this.title = title;
        this.content = content;
        this.sendNotification = sendNotification;
        this.remainderTime = remainderTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int isDone() {
        return isDone;
    }

    public void setDone(int done) {
        isDone = done;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSendNotification() {
        return sendNotification;
    }

    public void setSendNotification(int sendNotification) {
        this.sendNotification = sendNotification;
    }

    public String getRemainderTime() {
        return remainderTime;
    }

    public void setRemainderTime(String remainderTime) {
        this.remainderTime = remainderTime;
    }
}
