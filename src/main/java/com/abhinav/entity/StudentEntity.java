package com.abhinav.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student")
public class StudentEntity {		//Bean or POJO
	
	@Id
	@GeneratedValue					//@GeneratedValue is used for auto-generating studentid in database
	@Column(name="studentid")
	private long StudentId;
	
	@Column(name="studentname")
	private String StudentName;
	
//	@Transient						//@Transient is used if we don't want to store student_mobile in database
	@Column							//By default this column name will be student_mobile in database
	private String studentMobile;
	
	@Column(name="studentdob")
	private String studentDob;
	
	@Column(name="registrationdate")
	private String registrationDate;
	
	@Column(name="registrationstatus")
	private String registrationStatus;
	
	@Column(name="createdby")
	private String createdBy;
	
	@Column(name="updatedby")
	private String updatedBy;
	
	@Column(name="createdon")
	private LocalDateTime createdOn;
	
	@Column(name="updatedon")
	private LocalDateTime updatedOn;
	
}
