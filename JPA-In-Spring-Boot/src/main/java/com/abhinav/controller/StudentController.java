package com.abhinav.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.abhinav.model.StudentRequest;
import com.abhinav.service.StudentService;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Abhinav Tyagi
 *
 */
@Slf4j
@CrossOrigin
@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/studentCreateUpdate")
	public ResponseEntity<Object> studentCreateUpdateControllerMethod(@Valid @RequestBody StudentRequest request) throws Exception {		

		log.info("===========studentCreateUpdateControllerMethod starts===========");
		return studentService.studentCreateUpdateServiceMethod(request);		
	}
	
	@PostMapping("/studentDetailsRetrieve")
	public ResponseEntity<Object> studentDetailsRetrieveControllerMethod(@Valid @RequestBody StudentRequest request) throws Exception {		

		log.info("===========studentDetailsRetrieveControllerMethod starts===========");
		return studentService.studentDetailsRetrieveServiceMethod(request);		
	}
	
	@PostMapping("/studentListingRetrieve")
	public ResponseEntity<Object> studentListingRetrieveControllerMethod(@Valid @RequestBody StudentRequest request) throws Exception {		

		log.info("===========studentListingRetrieveControllerMethod starts===========");
		return studentService.studentListingRetrieveServiceMethod(request);		
	}
}
