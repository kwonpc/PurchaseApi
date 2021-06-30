package com.purchase.service;

import java.util.Optional;

import com.purchase.dto.UserDTO;
import com.purchase.entity.User;

public interface UserService {

	public Optional<User> get(UserDTO userDTO) throws Exception;
	
}
