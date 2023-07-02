package com.abhinav.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentErrorResponse implements Serializable {
	private static final long serialVersionUID = 4938005654259341247L;
	
	private int code;
	private String field;
	private String level;
	private String message;

}
