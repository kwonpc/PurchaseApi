package com.purchase.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.purchase.dto.UserDTO;
import com.purchase.entity.User;
import com.purchase.repository.UserRepository;
import com.purchase.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
    @Autowired
    private UserRepository userRepository;

	public Optional<User> get(UserDTO userDTO) throws Exception{	
		Optional<User> opt_user = userRepository.findById(userDTO.getId());
		return opt_user;
	}
}
