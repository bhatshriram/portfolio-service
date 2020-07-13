package com.service.portfolioservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="employers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employer_id;
    private Long user_id;
    private String employer_name;
    private String job_role;
    private String work_details;
    private Date start_year;
    private Date end_year;

    public Long getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(Long employer_id) {
        this.employer_id = employer_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getEmployer_name() {
        return employer_name;
    }

    public void setEmployer_name(String employer_name) {
        this.employer_name = employer_name;
    }

    public String getJob_role() {
        return job_role;
    }

    public void setJob_role(String job_role) {
        this.job_role = job_role;
    }

    public String getWork_details() {
        return work_details;
    }

    public void setWork_details(String work_details) {
        this.work_details = work_details;
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

    public Employer() {
    }
}
