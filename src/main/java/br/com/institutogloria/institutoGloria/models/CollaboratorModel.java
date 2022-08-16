package br.com.institutogloria.institutoGloria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "Collaborators")
public class CollaboratorModel {



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

    @Column(length = 30)
    private String ocupation;

    @OneToOne
    @JoinColumn(name = "PhotosModel_id", unique = true)
    private PhotosModel photo;
    //permissions

    private Boolean projectsAndNews = true;

    private Boolean collaborators = true;

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

    public Boolean getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(Boolean collaborators) {
        this.collaborators = collaborators;
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

    public CollaboratorModel(String name, String email, String password, String ocupation) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.ocupation = ocupation;
    }

    public CollaboratorModel(){

    }
}
