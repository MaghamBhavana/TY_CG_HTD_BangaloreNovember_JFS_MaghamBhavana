package com.capgemini.jpawithhibernate.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Student_OtherInfo")
public class Student_OtherInfo {
	@Id
	@Column
	private int sid;
	@Column
	private int pancard;
	@Column
	private String fathername;
	@Column
	private String mothername;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="stud_id")
	private Student student;

}
