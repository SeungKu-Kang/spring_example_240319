package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service // Service 계층이기 때문에
public class ReviewBO {

	@Autowired
	private ReviewMapper reviewMapper;
	// input: id(int)
	// output: Review (단건) or null             리스트를 조회했는데 비어있으면 null이 아니라 빈 리스트로 나옴[]
	public Review getReviewById(int id) {
		return reviewMapper.selectReviewById(id);
	}
}
