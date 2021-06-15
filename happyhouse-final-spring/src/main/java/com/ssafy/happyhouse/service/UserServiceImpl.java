package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.UserDao;
import com.ssafy.happyhouse.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	
	//---------------- user -----------------
	
	@Override
	public UserDto checkID(String id) {
		return userDao.checkID(id);
	}

	@Override
	public boolean joinUser(UserDto user) {
		userDao.joinUser(user);
		return true;
	}

	@Override
	public boolean updateUser(UserDto user) {
		userDao.updateUser(user);
		return true;
	}

	@Override
	public boolean deleteUser(String id) {
		userDao.deleteUser(id);
		return true;
	}

	@Override
	public UserDto detailUser(String id) {
		return userDao.detailUser(id); // 
	}
	
	
	@Override
	public String findPassword(UserDto user) {
		return userDao.findPassword(user);
	}

	@Override
	public UserDto login(UserDto user) {
		return userDao.login(user);
	}
	
	
	//---------------- admin -----------------

	@Override
	public List<UserDto> allUser() {
		return userDao.allUser();
	}

	@Override
	public List<UserDto> findByID(String id) {
		return userDao.findByID(id);
	}


}
