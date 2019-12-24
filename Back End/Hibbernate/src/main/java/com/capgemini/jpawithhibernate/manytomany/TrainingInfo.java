package com.capgemini.jpawithhibernate.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.capgemini.jpawithhibernate.onetoone.Student;

import lombok.Data;

@Data
@Entity
@Table(name="TrainingInfo")
public class TrainingInfo {
	@Id
	@Column
	private int tId;
	@Column
	private String tName;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="training_student",
	joinColumns = @JoinColumn(name="tId"),
	inverseJoinColumns=@JoinColumn(name="stud_id"))
	private List<Student> slist;
}
