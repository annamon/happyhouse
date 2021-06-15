package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.UserDto;

public interface UserDao {

	public UserDto checkID(String id);
	public void joinUser(UserDto user);
	public void updateUser(UserDto user);
	public void deleteUser(String id);
	public UserDto detailUser(String id);
	
	public String findPassword(UserDto user);
	public UserDto login(UserDto user);
	
	public List<UserDto> allUser();
	public List<UserDto> findByID(String id);

}
