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
public class StudentRequest implements Serializable {
	private static final long serialVersionUID = 3526224471629053852L;

	private long studentId;
	private String studentName;
	private String studentMobile;
	private String studentDob;
	private String username;

}
