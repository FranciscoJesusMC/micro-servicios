package com.ratingservice.service;

import java.util.List;

import com.ratingservice.entity.Rating;

public interface RatingService {

	public Rating createRating(Rating rating);
	
	public List<Rating> getAllRatings();
	
	public List<Rating> getAllRatingsByUserId(String userId);
	
	public List<Rating> getAllRatingsByHotelId(String hotelId);
}
