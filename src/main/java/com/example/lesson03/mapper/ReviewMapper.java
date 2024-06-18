package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.lesson03.domain.Review;

@Mapper
public interface ReviewMapper {
	
	// input : id
	// output : Review or null
	public Review selectReviewById(int id);
	
	public int insertReview(Review review);
	
	// @Param 하나의 맵으로 xml에 전송
	public int insertReviewAsField(
			@Param("storeId") int storeId12312313, 
			@Param("menu") String menu122, 
			@Param("userName") String userName3124123, 
			@Param("point") Double point123, 
			@Param("review") String review);
	
	public int updateReviewById(
			@Param("id") int id, 
			@Param("review") String review);
	
	public int deleteReviewById(int id);
}
