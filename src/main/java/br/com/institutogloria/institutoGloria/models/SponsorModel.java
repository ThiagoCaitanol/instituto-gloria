package br.com.institutogloria.institutoGloria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Sponsors")
public class SponsorModel {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 50)
	private String name;
	
	@Column()
	private String imageLink;
	
	@Column()
	private String externaLink;
	
	@Column()
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getExternaLink() {
		return externaLink;
	}

	public void setExternaLink(String externaLink) {
		this.externaLink = externaLink;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SponsorModel(String name, String imageLink, String externaLink, String description) {
		super();
		this.name = name;
		this.imageLink = imageLink;
		this.externaLink = externaLink;
		this.description = description;
	}
	
	public SponsorModel() {
		
	}
}
