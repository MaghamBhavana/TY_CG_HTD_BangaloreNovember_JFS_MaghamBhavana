package com.capgemini.hibernate.jpawithhibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {
	@Id
	@Column
	private int id;
	@Column(name="name")
	private String MovieName;
	@Column
	private String rating;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return MovieName;
	}
	public void setName(String name) {
		MovieName = name;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	} 


}
