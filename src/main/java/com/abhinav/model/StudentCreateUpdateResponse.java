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
public class StudentCreateUpdateResponse implements Serializable {
	private static final long serialVersionUID = -5458998721422278947L;
	
	private String studentId;

}
