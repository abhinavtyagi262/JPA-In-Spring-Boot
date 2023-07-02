package com.abhinav.model;

import java.io.Serializable;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetailsRetrieveRequest implements Serializable {
	private static final long serialVersionUID = 3526224471629053852L;
	
//	@PositiveOrZero
	@Positive
	private long studentId;

}
