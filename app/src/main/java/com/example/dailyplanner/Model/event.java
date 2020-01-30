package com.example.dailyplanner.Model;

public class event
{
    private int id;
    private String title;
    private String description;
    private String time;
    private String from_day;
    private String to_day;
    private  String location;

    public event()
    {

    }

    public event(int id, String title, String description, String time, String from_day, String to_day, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.time = time;
        this.from_day = from_day;
        this.to_day = to_day;
        this.location = location;
    }

    public event(String title, String description, String time, String from_day, String to_day, String location) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.from_day = from_day;
        this.to_day = to_day;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFrom_day() {
        return from_day;
    }

    public void setFrom_day(String from_day) {
        this.from_day = from_day;
    }

    public String getTo_day() {
        return to_day;
    }

    public void setTo_day(String to_day) {
        this.to_day = to_day;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
