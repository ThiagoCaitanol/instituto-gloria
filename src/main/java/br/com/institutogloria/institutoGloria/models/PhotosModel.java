package br.com.institutogloria.institutoGloria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "photo")
public class PhotosModel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "CollaboratorModel_id", unique = true)
    private CollaboratorModel collaborator;

    @Column(length = 100)
    private String description;

    @Column(nullable = false, length = 50)
    private String link;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CollaboratorModel getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(CollaboratorModel collaborator) {
        this.collaborator = collaborator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public PhotosModel(){

    }

    public PhotosModel(CollaboratorModel collaborator, String description, String link) {
        this.collaborator = collaborator;
        this.description = description;
        this.link = link;
    }
}

