package com.ratingservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ratingservice.entity.Rating;

public interface RatingRepository extends MongoRepository<Rating, String> {

	public List<Rating> findByUserId(String userId);
	
	public List<Rating> findByHotelId(String hotelId);
}
