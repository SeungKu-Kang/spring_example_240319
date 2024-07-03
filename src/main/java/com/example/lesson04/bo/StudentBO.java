package com.example.lesson04.bo;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	@Autowired
	private StudentMapper studentMapper;
	
	@Autowired
	private StudentRepository studentRepository;
	
	// input : 파라미터 4개
	// output: StudentEntity 단건
	public StudentEntity addStudent(String name, String phoneNumber, String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder()
				.name(name)
				.phoneNumber(phoneNumber)
				.email(email)
				.dreamJob(dreamJob)
				.createdAt(LocalDateTime.now()) // @CreationTimestamp 있으면 생략 가능
				.build();
		
		return studentRepository.save(student);
	}
	
	// input : Student
	// output: X
	
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	// input : id
	// output : Student
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
	// JPA - update
	
	// input : id, dreamJob 
	// output: StudentEntity - jpa는 엔티티를 리턴한다. or null (업데이트 대상이 없는 경우 null)
	public StudentEntity updateStudentDreamJobById (int id, String dreamJob) {		
		// 기존 데이터 조회 => StudentEntity
		StudentEntity student = studentRepository.findById(id).orElse(null);
		
		// Entity의 데이터 값을 변경해놓는다.(update)
		if (student != null) {
			student = student.toBuilder() // toBuilder는 기존 필드값을 유지하고 일부만 변경
					.dreamJob(dreamJob)
					.build(); // 꼭 객체에 다시 저장해야함 (바뀐것 적용)
			// save 요청
			student = studentRepository.save(student);
		}
		
		// update
		
		return student;
	}
	
	// input : id
	// output: X
	public void deleteStudentById(int id) {
		// 방법 1)
//		StudentEntity student = studentRepository.findById(id).orElse(null);
//		if (student != null) {
//			studentRepository.delete(student);
//		}
		
		// 방법 2) Optional 활용하기
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
		
	}
	
}
