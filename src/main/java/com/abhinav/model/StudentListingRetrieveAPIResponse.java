package com.abhinav.model;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentListingRetrieveAPIResponse implements Serializable {
	private static final long serialVersionUID = 4938005654259341247L;
	
	private List<StudentListingRetrieveResponse> result;
	private List<StudentErrorResponse> errors;

}
