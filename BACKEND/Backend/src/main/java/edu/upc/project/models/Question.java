package edu.upc.project.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"id", "date", "title", "message", "sender"})
public class Question {
    private Integer id;
    private String date;
    private String title;
    private String message;
    private String sender;

    public Question() {
    }

    public Question(Integer id, String date, String title, String message, String sender) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.message = message;
        this.sender = sender;
    }

    @XmlElement(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @XmlElement(name = "sender")
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", date=" + date + ", title=" + title + ", message=" + message + ", sender=" + sender + "]";
    }
}