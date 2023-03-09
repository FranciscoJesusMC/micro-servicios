package com.hotelservice.service;

import java.util.List;

import com.hotelservice.entity.Hotel;

public interface HotelService {
	
	public Hotel createHotel(Hotel hotel);
	
	public List<Hotel> getAll();
	
	public Hotel getHotelById(String id);

}
