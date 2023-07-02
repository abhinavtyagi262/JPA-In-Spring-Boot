package com.abhinav.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentListingRetrieveRequest implements Serializable {
	private static final long serialVersionUID = 3526224471629053852L;

	@NotBlank(message = "Name is mandatory")
	private String studentName;

}
