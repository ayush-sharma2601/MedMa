package com.example.radyapp.DoctorSide.ResponseModels;

public class NoticeModel {
    String heading;
    String source;
    String date;
    String content;

    public NoticeModel(String heading, String source, String date, String content) {
        this.heading = heading;
        this.source = source;
        this.date = date;
        this.content = content;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
