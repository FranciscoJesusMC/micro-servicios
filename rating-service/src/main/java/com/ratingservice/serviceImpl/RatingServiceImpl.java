package com.ratingservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingservice.entity.Rating;
import com.ratingservice.repository.RatingRepository;
import com.ratingservice.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepository ratingRepositorio;

	@Override
	public Rating createRating(Rating rating) {
		return ratingRepositorio.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepositorio.findAll();
	}

	@Override
	public List<Rating> getAllRatingsByUserId(String userId) {
		return ratingRepositorio.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingsByHotelId(String hotelId) {
		return ratingRepositorio.findByHotelId(hotelId);
	}

}
