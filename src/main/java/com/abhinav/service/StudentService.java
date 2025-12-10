package com.abhinav.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abhinav.constant.StudentConstant;
import com.abhinav.entity.StudentEntity;
import com.abhinav.model.StudentCreateUpdateAPIResponse;
import com.abhinav.model.StudentCreateUpdateRequest;
import com.abhinav.model.StudentCreateUpdateResponse;
import com.abhinav.model.StudentDetailsRetrieveAPIResponse;
import com.abhinav.model.StudentDetailsRetrieveRequest;
import com.abhinav.model.StudentDetailsRetrieveResponse;
import com.abhinav.model.StudentListingRetrieveAPIResponse;
import com.abhinav.model.StudentListingRetrieveRequest;
import com.abhinav.model.StudentListingRetrieveResponse;
import com.abhinav.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Abhinav Tyagi
 *
 */
@Slf4j
@Service
public class StudentService {

	@Value("${com.abhinav.studentCreateUpdate.url}")
	private String studentCreateUpdateUrl;

	@Autowired
	StudentRepository studentRepository;

	@Transactional
	public ResponseEntity<Object> studentCreateUpdateServiceMethod(StudentCreateUpdateRequest request) throws Exception {
		log.info("===========studentCreateUpdate API url: " + studentCreateUpdateUrl + "===========");
		log.info("===========studentCreateUpdateServiceMethod starts===========");
		LocalDateTime localDateTime = LocalDateTime.now();
		String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		StudentCreateUpdateAPIResponse response = new StudentCreateUpdateAPIResponse();
		StudentCreateUpdateResponse result = null;
		Optional<StudentEntity> studentEntityOptional = studentRepository.findById(request.getStudentId());

		if (!studentEntityOptional.isPresent()) {
			log.info("===========creating new student===========");
			try {
				StudentEntity studentEntity = new StudentEntity();
				studentEntity.setStudentName(request.getStudentName());
				studentEntity.setStudentMobile(request.getStudentMobile());

				Date studentDobDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getStudentDob());
				String studentDobString = new SimpleDateFormat("dd-MM-yyyy").format(studentDobDate);

				studentEntity.setStudentDob(studentDobString);
				studentEntity.setRegistrationDate(currentDate);
				studentEntity.setRegistrationStatus(StudentConstant.REGISTRATION_STATUS_REGISTERED);
				studentEntity.setCreatedBy(request.getUsername());
				studentEntity.setUpdatedBy(request.getUsername());
				studentEntity.setCreatedOn(localDateTime);
				studentEntity.setUpdatedOn(localDateTime);
				StudentEntity studentEntitySaved = studentRepository.save(studentEntity);
				result = new StudentCreateUpdateResponse();
				result.setStudentId(String.valueOf(studentEntitySaved.getStudentId()));
			} catch (Exception e) {
				log.error("===========creating new student catch block===========");
				e.printStackTrace();
				return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
			}

		} else {
			log.info("===========updating existing student===========");
			try {
				StudentEntity studentEntity = studentEntityOptional.get();
				studentEntity.setStudentId(request.getStudentId());
				studentEntity.setStudentName(request.getStudentName());
				studentEntity.setStudentMobile(request.getStudentMobile());

				Date studentDobDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getStudentDob());
				String studentDobString = new SimpleDateFormat("dd-MM-yyyy").format(studentDobDate);

				studentEntity.setStudentDob(studentDobString);
				studentEntity.setRegistrationDate(studentEntity.getRegistrationDate());
				studentEntity.setRegistrationStatus(StudentConstant.REGISTRATION_STATUS_REGISTERED);
				studentEntity.setCreatedBy(studentEntity.getCreatedBy());
				studentEntity.setUpdatedBy(request.getUsername());
				studentEntity.setCreatedOn(studentEntity.getCreatedOn());
				studentEntity.setUpdatedOn(localDateTime);
				StudentEntity studentEntitySaved = studentRepository.save(studentEntity);
				result = new StudentCreateUpdateResponse();
				result.setStudentId(String.valueOf(studentEntitySaved.getStudentId()));
			} catch (Exception e) {
				log.error("===========updating existing student catch block===========");
				e.printStackTrace();
				return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
			}
		}
		response.setResult(result);
		log.info("===========studentCreateUpdateServiceMethod ends===========");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	public ResponseEntity<Object> studentDetailsRetrieveServiceMethod(StudentDetailsRetrieveRequest request) throws Exception {
		log.info("===========studentDetailsRetrieveServiceMethod starts===========");
		StudentDetailsRetrieveAPIResponse response = new StudentDetailsRetrieveAPIResponse();
		StudentDetailsRetrieveResponse result = null;
		Optional<StudentEntity> studentEntityOptional = studentRepository.findById(request.getStudentId());

		if (!studentEntityOptional.isPresent()) {
			log.info("===========student not found in database===========");
		} else {
			log.info("===========student found in database===========");
			try {
				StudentEntity studentEntity = studentEntityOptional.get();
				result = new StudentDetailsRetrieveResponse();
				result.setStudentId(String.valueOf(studentEntity.getStudentId()));
				result.setStudentName(studentEntity.getStudentName());
				result.setStudentMobile(studentEntity.getStudentMobile());
				result.setStudentDob(studentEntity.getStudentDob());
				result.setRegistrationDate(studentEntity.getRegistrationDate());
				result.setRegistrationStatus(studentEntity.getRegistrationStatus());
				result.setCreatedBy(studentEntity.getCreatedBy());
				result.setUpdatedBy(studentEntity.getUpdatedBy());
				result.setCreatedOn(studentEntity.getCreatedOn());
				result.setUpdatedOn(studentEntity.getUpdatedOn());
			} catch (Exception e) {
				log.error("===========studentDetailsRetrieveServiceMethod catch block===========");
				e.printStackTrace();
				return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
			}
		}
		response.setResult(result);
		log.info("===========studentDetailsRetrieveServiceMethod ends===========");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

	public ResponseEntity<Object> studentListingRetrieveServiceMethod(StudentListingRetrieveRequest request) throws Exception {
		log.info("===========studentListingRetrieveServiceMethod starts===========");
		StudentListingRetrieveAPIResponse response = new StudentListingRetrieveAPIResponse();
		List<StudentListingRetrieveResponse> resultList = null;
		List<StudentEntity> studentEntityList = studentRepository.findByStudentName(request.getStudentName());

		if (studentEntityList.isEmpty() || studentEntityList == null) {
			log.info("===========student not found in database===========");
		} else {
			log.info("===========student found in database===========");
			try {
				resultList = new ArrayList<StudentListingRetrieveResponse>();
				for (StudentEntity studentEntity : studentEntityList) {
					StudentListingRetrieveResponse result = new StudentListingRetrieveResponse();
					result.setStudentId(String.valueOf(studentEntity.getStudentId()));
					result.setStudentName(studentEntity.getStudentName());
					result.setStudentMobile(studentEntity.getStudentMobile());
					result.setStudentDob(studentEntity.getStudentDob());
					result.setRegistrationDate(studentEntity.getRegistrationDate());
					result.setRegistrationStatus(studentEntity.getRegistrationStatus());
					result.setCreatedBy(studentEntity.getCreatedBy());
					result.setUpdatedBy(studentEntity.getUpdatedBy());
					result.setCreatedOn(studentEntity.getCreatedOn());
					result.setUpdatedOn(studentEntity.getUpdatedOn());
					resultList.add(result);
				}
			} catch (Exception e) {
				log.error("===========studentListingRetrieveServiceMethod catch block===========");
				e.printStackTrace();
				return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
			}
		}
		response.setResult(resultList);
		log.info("===========studentListingRetrieveServiceMethod ends===========");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<Object> getStudentDetailsServiceMethod(long studentId) throws Exception {
		log.info("===========getStudentDetailsServiceMethod starts===========");
		StudentDetailsRetrieveAPIResponse response = new StudentDetailsRetrieveAPIResponse();
		StudentDetailsRetrieveResponse result = null;
		Optional<StudentEntity> studentEntityOptional = studentRepository.findById(studentId);

		if (!studentEntityOptional.isPresent()) {
			log.info("===========student not found in database===========");
		} else {
			log.info("===========student found in database===========");
			try {
				StudentEntity studentEntity = studentEntityOptional.get();
				result = new StudentDetailsRetrieveResponse();
				result.setStudentId(String.valueOf(studentEntity.getStudentId()));
				result.setStudentName(studentEntity.getStudentName());
				result.setStudentMobile(studentEntity.getStudentMobile());
				result.setStudentDob(studentEntity.getStudentDob());
				result.setRegistrationDate(studentEntity.getRegistrationDate());
				result.setRegistrationStatus(studentEntity.getRegistrationStatus());
				result.setCreatedBy(studentEntity.getCreatedBy());
				result.setUpdatedBy(studentEntity.getUpdatedBy());
				result.setCreatedOn(studentEntity.getCreatedOn());
				result.setUpdatedOn(studentEntity.getUpdatedOn());
			} catch (Exception e) {
				log.error("===========getStudentDetailsServiceMethod catch block===========");
				e.printStackTrace();
				return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
			}
		}
		response.setResult(result);
		log.info("===========getStudentDetailsServiceMethod ends===========");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	
	public ResponseEntity<?> getStudentDetails2ServiceMethod(StudentDetailsRetrieveRequest request) throws Exception {
		log.info("===========getStudentDetails2ServiceMethod starts===========");
		StudentDetailsRetrieveAPIResponse response = new StudentDetailsRetrieveAPIResponse();
		StudentDetailsRetrieveResponse result = null;
		Optional<StudentEntity> studentEntityOptional = studentRepository.findById(request.getStudentId());

		if (!studentEntityOptional.isPresent()) {
			log.info("===========student not found in database===========");
		} else {
			log.info("===========student found in database===========");
			try {
				StudentEntity studentEntity = studentEntityOptional.get();
				result = new StudentDetailsRetrieveResponse();
				result.setStudentId(String.valueOf(studentEntity.getStudentId()));
				result.setStudentName(studentEntity.getStudentName());
				result.setStudentMobile(studentEntity.getStudentMobile());
				result.setStudentDob(studentEntity.getStudentDob());
				result.setRegistrationDate(studentEntity.getRegistrationDate());
				result.setRegistrationStatus(studentEntity.getRegistrationStatus());
				result.setCreatedBy(studentEntity.getCreatedBy());
				result.setUpdatedBy(studentEntity.getUpdatedBy());
				result.setCreatedOn(studentEntity.getCreatedOn());
				result.setUpdatedOn(studentEntity.getUpdatedOn());
			} catch (Exception e) {
				log.error("===========getStudentDetails2ServiceMethod catch block===========");
				e.printStackTrace();
				return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
			}
		}
		response.setResult(result);
		log.info("===========getStudentDetails2ServiceMethod ends===========");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
