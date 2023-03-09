package com.hotelservice.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelservice.entity.Hotel;
import com.hotelservice.exceptions.ResourceNotFoundException;
import com.hotelservice.repository.HotelRepository;
import com.hotelservice.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository hotelRepository;
	

	@Override
	public Hotel createHotel(Hotel hotel) {
		String randonId = UUID.randomUUID().toString();
		hotel.setId(randonId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(String id) {
		return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with given id not found"));
	}

	
}
