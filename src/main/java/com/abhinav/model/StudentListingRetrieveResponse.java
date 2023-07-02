package com.abhinav.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentListingRetrieveResponse implements Serializable {
	private static final long serialVersionUID = 2644354982877582404L;
	
	private String studentId;
	private String studentName;
	private String studentMobile;
	private String studentDob;
	private String registrationDate;
	private String registrationStatus;
	private String createdBy;
	private String updatedBy;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

}
