package com.example.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.lesson04.domain.Student;

@Mapper
public interface StudentMapper {

	public int insertStudent(Student student); //StudentBo에서 그대로 가져올 때 왜 void에서 int로 바뀌었고 왜 add에서 insert로 바꿨는지
}
