package com.capgemini.jpawithhibernate.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.capgemini.jpawithhibernate.manytomany.TrainingInfo;
import com.capgemini.jpawithhibernate.onetomany.Student_Experience;

import lombok.Data;
import lombok.ToString.Exclude;

@Data
@Entity
@Table(name="Student")
public class Student {
	@Id
	@Column
	private int stud_id;
	@Column
	private String stud_name;
	@Column
	private String stud_email;
	@Column
	private String stud_password;
	@Exclude
	@OneToOne(cascade=CascadeType.ALL,mappedBy="student")
	private Student_OtherInfo info;
	@Exclude
	@OneToMany(cascade=CascadeType.ALL,mappedBy="info")
	private Student_Experience stuinfo;
	@Exclude
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="slist")
	private TrainingInfo info1;
	

}
