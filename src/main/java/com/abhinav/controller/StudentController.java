package com.abhinav.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
@Tag(name = "Student Registration APIs", description = "APIs for Student Registration and Retrieval")
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
	
//	@PreAuthorize("hasAnyAuthority('SCOPE_read')")
	@GetMapping("/getStudentDetails") // URL: http://localhost:9080/abhinav/getStudentDetails?studentId=1&studentName=Ram
	public ResponseEntity<Object> getStudentDetailsControllerMethod(@RequestParam("studentId") long studentId,
                                                                    @RequestParam("studentName") String studentName) throws Exception {

		log.info("===========getStudentDetailsControllerMethod starts===========");
        log.info("RequestParam studentName is: " + studentName);
		return studentService.getStudentDetailsServiceMethod(studentId);		
	}
	
//	@PreAuthorize("hasAnyAuthority('SCOPE_read')")
	@GetMapping("/getStudentDetails2") // URL: http://localhost:9080/abhinav/getStudentDetails2?studentId=1
	public ResponseEntity<Object> getStudentDetails2ControllerMethod(@Valid @ModelAttribute StudentDetailsRetrieveRequest request) throws Exception {		

		log.info("===========getStudentDetails2ControllerMethod starts===========");
		return studentService.getStudentDetails2ServiceMethod(request);
	}

//	@PreAuthorize("hasAnyAuthority('SCOPE_read')")
    @GetMapping("/getStudentDetails3/{studentId}/{studentName}") // URL: http://localhost:9080/abhinav/getStudentDetails3/1/Ram
    public ResponseEntity<Object> getStudentDetails3ControllerMethod(@PathVariable("studentId") long studentId,
                                                                     @PathVariable("studentName") String studentName) throws Exception {

        log.info("===========getStudentDetails3ControllerMethod starts===========");
        log.info("PathVariable studentName is: " + studentName);
        return studentService.getStudentDetailsServiceMethod(studentId);
    }
}
