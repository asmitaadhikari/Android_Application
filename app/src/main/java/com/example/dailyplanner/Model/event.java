package com.example.dailyplanner.Model;

public class event {

  private String notesSchema;
  private String location;
  private String date;
  private String time;


  public event(String notesSchema, String location, String date, String time) {
    this.notesSchema=notesSchema;
    this.location=location;
    this.date=date;
    this.time=time;


  }

  public String getNotesSchema() {
    return notesSchema;
  }

  public void setNotesSchema(String notesSchema) {
    this.notesSchema = notesSchema;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }
}

