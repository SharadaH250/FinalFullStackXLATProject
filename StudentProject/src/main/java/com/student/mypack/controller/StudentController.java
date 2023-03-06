package com.student.mypack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.mypack.Exception.ResourceNotFoundException;
import com.student.mypack.model.Student;
import com.student.mypack.repository.StudentRepository;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
//	private Optional<Student> student;
	
	//Get all students
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/students")
	public List<Student>getAllStudents(){
		return studentRepository.findAll();
		
	}
	//Create student Rest API
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student stud)
	{
		return studentRepository.save(stud);
		
	}
	
	//get employee by id Rest API
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/students/{id}")
	public  ResponseEntity<Optional<Student>> getStudentById(@PathVariable int id)
	{
		Optional<Student> student=studentRepository.findById(id);
		return ResponseEntity.ok(student);
		
	}
	
	//Update Student Rest API
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody Student studentDetails)
	{
		Student student = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
				
				
		student.setFirstname(studentDetails.getFirstname());
		student.setLastname(studentDetails.getLastname());
		student.setClasses(studentDetails.getClasses());
		student.setPhonenumber(studentDetails.getPhonenumber());
		student.setAddress(studentDetails.getAddress());
		
		Student updatedStudent=studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
		
		
	}
	
	
	// delete employee rest api
	@CrossOrigin(origins="http://localhost:4200")
		@DeleteMapping("/students/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable int id){
			Student stud = studentRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Student not exist with id :" + id));
			
			studentRepository.delete(stud);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
	
	
	
	
	
}
