package com.abhinav.model;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentCreateUpdateRequest implements Serializable {
	private static final long serialVersionUID = 3526224471629053852L;

	private long studentId;
	
	@NotBlank(message="Name is mandatory")
	@Size(min=2, max=20)
	private String studentName;
	
	private String studentMobile;
	private String studentDob;
	private String username;

}
