package com.capgemini.healthcaresystem.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Appoinments_Info")
public class Appointment {

	@Id
	@Column
	private long appointmentId;
	@Column
	private Date dateAndTime;
	@Column
	private String approvalStatus;
	@Column
	private int userId;
}
