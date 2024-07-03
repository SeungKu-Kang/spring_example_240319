package com.example.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson07.entity.StudentEntity;

@RequestMapping("/lesson07/ex01")
@RestController
public class Lesson07Ex01RestController {

	@Autowired
	private StudentBO studentBO;
	
	// C: create
	@GetMapping("/create")
	public StudentEntity create() {
		String name="박진아";
		String phoneNumber = "010-1234-1234";
		String email = "jina@naver.com";
		String dreamJob = "간호사";
		
		return studentBO.addStudent(name, phoneNumber, email, dreamJob);
		
	}
	
	// U : update
	@GetMapping("/update")
	public StudentEntity update() {
		// id가 7번인 것의 dreamJob을 '간호사'에서 '기획자'로 변경
		return studentBO.updateStudentDreamJobById(7, "기획자");
	}
	
	// D : delete
	@GetMapping("/delete")
	public String delete() {
		// id가 10번인 데이터 삭제
		studentBO.deleteStudentById(5);
		
		return "삭제 성공";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
