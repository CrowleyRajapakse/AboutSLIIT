package com.fsociety2.aboutsliit;

/**
 * Created by Isuru Jayathilaka on 2018-03-30.
 */

public class AcademicStaffModel {

    public int id;
    public String title;
    public String name;
    public String position;

    public AcademicStaffModel(int id, String title, String name, String position) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.position = position;
    }

    public AcademicStaffModel(String name, String position){
        this.name = name;
        this.position = position;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
