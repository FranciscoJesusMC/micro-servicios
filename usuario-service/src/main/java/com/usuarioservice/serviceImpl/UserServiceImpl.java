package com.usuarioservice.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.usuarioservice.entity.Hotel;
import com.usuarioservice.entity.Rating;
import com.usuarioservice.entity.User;
import com.usuarioservice.exceptions.ResourceNotFoundException;
import com.usuarioservice.repository.UserRepository;
import com.usuarioservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User createUser(User user) {
		String randomId = UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User findUserById(String id) {
		User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro el id: "+id));
		
		//Recuperamos en un array los ratigns del usuario
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/api/rating/user/"+user.getUserId(), Rating[].class);
		
		//Transformamos a una lista ese arreglo
		List<Rating> ratings = Arrays.asList(ratingsOfUser);
		
		//Recorremos cada rating para obtener el hotel y lo devolvemos juntos
		List<Rating> ratingList = ratings.stream().map(rating ->{
			
			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE:8082/api/hotel/"+rating.getHotelId(), Hotel.class);
			Hotel hotel =forEntity.getBody();
			
			rating.setHotel(hotel);
			return rating;
			
		}).collect(Collectors.toList());
		
		user.setRatings(ratingList);
		
		return user;
	}

}
