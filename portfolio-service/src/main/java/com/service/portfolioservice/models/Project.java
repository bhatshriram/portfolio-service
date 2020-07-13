package com.service.portfolioservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javafx.scene.input.GestureEvent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="projects")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;
    private Long user_id;
    private Long employer_id;
    private String project_name;
    private String client_name;
    private String project_details;
    private String tech_stack;
    private String project_url;
    private String source_url;
    private byte[] project_image;

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getEmployer_id() {
        return employer_id;
    }

    public void setEmployer_id(Long employer_id) {
        this.employer_id = employer_id;
    }

    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(Long project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getProject_details() {
        return project_details;
    }

    public void setProject_details(String project_details) {
        this.project_details = project_details;
    }

    public String getTech_stack() {
        return tech_stack;
    }

    public void setTech_stack(String tech_stack) {
        this.tech_stack = tech_stack;
    }

    public String getProject_url() {
        return project_url;
    }

    public void setProject_url(String project_url) {
        this.project_url = project_url;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public byte[] getProject_image() {
        return project_image;
    }

    public void setProject_image(byte[] project_image) {
        this.project_image = project_image;
    }

    public Project() {

    }
}
