package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseSearchDto;
import com.ssafy.happyhouse.dto.LikeDto;

@Repository
public class HouseDaoImpl implements HouseDao {
	
	private String ns = "com.ssafy.happyhouse.dao.HouseMapper.";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<HouseDto> findAll() {
		return sqlSession.selectList(ns+"findAll");
	}

	@Override
	public List<HouseDto> findByName(HouseSearchDto house) {
		return sqlSession.selectList(ns+"findByName", house);
	}

	@Override
	public List<HouseDto> findByCity(HouseSearchDto house) {
		return sqlSession.selectList(ns+"findByCity", house);
	}

	@Override
	public List<HouseDto> findByCityName(HouseSearchDto house) {
		return sqlSession.selectList(ns+"findByCityName", house);
	}

	@Override
	public List<HouseDto> findByGugun(HouseSearchDto house) {
		return sqlSession.selectList(ns+"findByGugun", house);
	}

	@Override
	public List<HouseDto> findByGugunName(HouseSearchDto house) {
		return sqlSession.selectList(ns+"findByGugunName", house);
	}

	@Override
	public List<HouseDto> findByDong(HouseSearchDto house) {
		return sqlSession.selectList(ns+"findByDong", house);
	}

	@Override
	public List<HouseDto> findByDongName(HouseSearchDto house) {
		return sqlSession.selectList(ns+"findByDongName", house);
	}

	@Override
	public List<String> cityList() {
		return sqlSession.selectList(ns+"cityList");
	}

	@Override
	public List<String> gugunList(String city) {
		return sqlSession.selectList(ns+"gugunList", city);
	}

	@Override
	public List<String> dongList(String gugun) {
		return sqlSession.selectList(ns+"dongList", gugun);
	}

	@Override
	public List<String> schoolList(String no) {
		return sqlSession.selectList(ns+"schoolList", no);
	}


	@Override
	public void insertLike(LikeDto like) {
		sqlSession.insert(ns+"insertLike", like);
	}

	@Override
	public void deleteLike(LikeDto unlike) {
		sqlSession.delete(ns+"deleteLike", unlike);
	}

	@Override
	public List<HouseDto> showLike(String id) {
		return sqlSession.selectList(ns+"showLike", id);
	}
}
