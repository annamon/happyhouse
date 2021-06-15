package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {

	private String ns = "com.ssafy.happyhouse.dao.UserMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	
	//---------------- user -----------------
	@Override
	public UserDto checkID(String id) {
		return sqlSession.selectOne(ns+"checkID", id);
	}
	
	@Override
	public void joinUser(UserDto user) {
		sqlSession.insert(ns+"joinUser", user);
	}

	@Override
	public void updateUser(UserDto user) {
		sqlSession.update(ns+"updateUser", user);
	}

	@Override
	public void deleteUser(String id) {
		sqlSession.delete(ns+"deleteUser", id);
	}
	
	@Override
	public UserDto detailUser(String id) {
		return sqlSession.selectOne(ns+"detailUser", id);
	}

	@Override
	public String findPassword(UserDto user) {
		return sqlSession.selectOne(ns+"findPassword", user);
	}

	@Override
	public UserDto login(UserDto user) {
		return sqlSession.selectOne(ns+"login", user);
	}

	
	//---------------- admin -----------------
	@Override
	public List<UserDto> allUser() {
		return sqlSession.selectList(ns+"allUser");
	}

	@Override
	public List<UserDto> findByID(String id) {
		return sqlSession.selectList(ns+"findByID");
	}


}
