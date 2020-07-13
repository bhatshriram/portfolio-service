package com.service.portfolioservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="schools")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long school_id;
    private Long user_id;
    private String school_name;
    private String course;
    private String address;
    private Date start_year;
    private Date end_year;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getSchool_id() {
        return school_id;
    }

    public void setSchool_id(Long school_id) {
        this.school_id = school_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getStart_year() {
        return start_year;
    }

    public void setStart_year(Date start_year) {
        this.start_year = start_year;
    }

    public Date getEnd_year() {
        return end_year;
    }

    public void setEnd_year(Date end_year) {
        this.end_year = end_year;
    }

    public School() {

    }
}
