package com.hotelservice.controller;

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

import com.hotelservice.entity.Hotel;
import com.hotelservice.service.HotelService;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel newHotel= hotelService.createHotel(hotel);
		return new ResponseEntity<>(newHotel,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		List<Hotel> hotels = hotelService.getAll();
		return ResponseEntity.ok(hotels);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable(name = "id")String id){
		Hotel hotel = hotelService.getHotelById(id);
		return ResponseEntity.ok(hotel);
	}
	
}
