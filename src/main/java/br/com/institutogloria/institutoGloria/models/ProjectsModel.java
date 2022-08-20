package br.com.institutogloria.institutoGloria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Projects")
public class ProjectsModel {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(nullable = false, length = 50)
    private String title;
    
    @Column(nullable = false, length = 1000)
    private String subtext;
    
    @Column(nullable = false, length = 10000)
    private String text;
    
    @Column(nullable = false, length = 300)
    private String photoLink;
    
    @Column(nullable = false, length = 10000)
    private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtext() {
		return subtext;
	}

	public void setSubtext(String subtext) {
		this.subtext = subtext;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ProjectsModel(String title, String subtext, String text, String photoLink, String content) {
		super();
		this.title = title;
		this.subtext = subtext;
		this.text = text;
		this.photoLink = photoLink;
		this.content = content;
	}
    
    public ProjectsModel() {
    	
    }
}
