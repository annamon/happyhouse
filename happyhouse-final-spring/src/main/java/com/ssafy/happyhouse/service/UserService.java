package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.UserDto;

public interface UserService {

	public UserDto checkID(String id);
	public boolean joinUser(UserDto user);
	public boolean updateUser(UserDto user);
	public boolean deleteUser(String id);
	public UserDto detailUser(String id);
	
	public String findPassword(UserDto user);
	public UserDto login(UserDto user);
	
	public List<UserDto> allUser();
	public List<UserDto> findByID(String id);
	
}
