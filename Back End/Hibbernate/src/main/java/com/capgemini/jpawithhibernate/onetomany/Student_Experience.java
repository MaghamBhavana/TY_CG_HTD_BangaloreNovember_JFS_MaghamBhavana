package com.capgemini.jpawithhibernate.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.capgemini.jpawithhibernate.onetoone.Student;
import lombok.Data;

@Data
@Entity
@Table(name="Student_Experience")
public class Student_Experience {
	@Id
	@Column
	private int expId;
	@Column
	private String cname;
	@Column
	private int noOfYear;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="stud_id")
	private Student info;
}
