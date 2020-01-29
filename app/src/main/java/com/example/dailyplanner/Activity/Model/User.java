package com.example.dailyplanner.Activity.Model;

public class User {
    private String fname;
    private String lname;
    private String Username;
    private String password;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;


    }
    public User(String fname, String lname,String username,String password)
    {
        this.fname=fname;
        this.lname=lname;
        this.Username=username;
        this.password=password;

    }
    public User(String username,String password)
    {
        this.Username=username;
        this.password=password;
    }
}
