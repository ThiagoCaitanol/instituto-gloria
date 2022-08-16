package br.com.institutogloria.institutoGloria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "admin")
public class AdminModel {


    //login reference

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 50)
    private String password;


    //permissions

    private Boolean projectsAndNews = true;

    private Boolean collaboratorsPermissions = true;

    private Boolean collaborators = true;

    private Boolean partners = true;

    private Boolean videos = true;

    private Boolean cards = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getProjectsAndNews() {
        return projectsAndNews;
    }

    public void setProjectsAndNews(Boolean projectsAndNews) {
        this.projectsAndNews = projectsAndNews;
    }

    public Boolean getCollaboratorsPermissions() {
        return collaboratorsPermissions;
    }

    public void setCollaboratorsPermissions(Boolean collaboratorsPermissions) {
        this.collaboratorsPermissions = collaboratorsPermissions;
    }

    public Boolean getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(Boolean collaborators) {
        this.collaborators = collaborators;
    }

    public Boolean getPartners() {
        return partners;
    }

    public void setPartners(Boolean partners) {
        this.partners = partners;
    }

    public Boolean getVideos() {
        return videos;
    }

    public void setVideos(Boolean videos) {
        this.videos = videos;
    }

    public Boolean getCards() {
        return cards;
    }

    public void setCards(Boolean cards) {
        this.cards = cards;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AdminModel(){

    }

    public AdminModel(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
