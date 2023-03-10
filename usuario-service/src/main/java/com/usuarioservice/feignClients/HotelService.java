package com.usuarioservice.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.usuarioservice.entity.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

	@GetMapping("/api/hotel/{id}")
	public Hotel getHotel(@PathVariable(name = "id")String id);
}
