package br.com.institutogloria.institutoGloria.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Letter")
public class LetterModel {

	
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private UserModel user;
	
	@Column(length = 100)
	private String titleLetter;
	
	@Column(length = 5000)
	private String letter;
	
	@Column()
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getTitleLetter() {
		return titleLetter;
	}

	public void setTitleLetter(String titleLetter) {
		this.titleLetter = titleLetter;
	}

	public String getLetter() {
		return letter;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public LetterModel(UserModel user, String titleLetter, String letter) {
		super();
		this.user = user;
		this.titleLetter = titleLetter;
		this.letter = letter;
	}
	
	
	public LetterModel() {
		
	}

//	public LetterModel(UserModel user2, String titleLetter2, LetterModel letter2) {
//		// TODO Auto-generated constructor stub
//	}
}
