package edu.bjtu.xxq.model;

public class Report {

    private String name;
    private String type;
    private String date;
    private String content;

    public String getName() {
        return name;
    }

    public Report setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Report setType(String type) {
        this.type = type;
        return this;
    }

    public String getDate() {
        return date;
    }

    public Report setDate(String date) {
        this.date = date;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Report setContent(String content) {
        this.content = content;
        return this;
    }
}
