package com.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingservice.entity.Rating;
import com.ratingservice.service.RatingService;

@RestController
@RequestMapping("/api/rating")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating newRating = ratingService.createRating(rating);
		return new ResponseEntity<>(newRating,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> ratings = ratingService.getAllRatings();
		return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable(name = "userId")String userId){
		List<Rating> ratings = ratingService.getAllRatingsByUserId(userId);
		return ResponseEntity.ok(ratings);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable(name = "hotelId")String hotelId){
		List<Rating> ratings = ratingService.getAllRatingsByHotelId(hotelId);
		return ResponseEntity.ok(ratings);
	}

}
