package com.abhinav.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhinav.model.StudentCreateUpdateRequest;
import com.abhinav.model.StudentDetailsRetrieveRequest;
import com.abhinav.model.StudentListingRetrieveRequest;
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
	
//	@PreAuthorize("hasAnyAuthority('SCOPE_create')")
	@PostMapping("/studentCreateUpdate")
	public ResponseEntity<Object> studentCreateUpdateControllerMethod(@Valid @RequestBody StudentCreateUpdateRequest request) throws Exception {		

		log.info("===========studentCreateUpdateControllerMethod starts===========");
		return studentService.studentCreateUpdateServiceMethod(request);		
	}
	
//	@PreAuthorize("hasAnyAuthority('SCOPE_read')")
	@PostMapping("/studentDetailsRetrieve")
	public ResponseEntity<Object> studentDetailsRetrieveControllerMethod(@Valid @RequestBody StudentDetailsRetrieveRequest request) throws Exception {		

		log.info("===========studentDetailsRetrieveControllerMethod starts===========");
		return studentService.studentDetailsRetrieveServiceMethod(request);		
	}
	
//	@PreAuthorize("hasAnyAuthority('SCOPE_read')")
	@PostMapping("/studentListingRetrieve")
	public ResponseEntity<Object> studentListingRetrieveControllerMethod(@Valid @RequestBody StudentListingRetrieveRequest request) throws Exception {		

		log.info("===========studentListingRetrieveControllerMethod starts===========");
		return studentService.studentListingRetrieveServiceMethod(request);		
	}
}
