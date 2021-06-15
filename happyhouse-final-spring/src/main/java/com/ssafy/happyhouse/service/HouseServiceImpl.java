package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.HouseDao;
import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseSearchDto;
import com.ssafy.happyhouse.dto.LikeDto;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private HouseDao houseDao;

	@Override
	public List<HouseDto> findAll() {
		return houseDao.findAll();
	}

	@Override
	public List<HouseDto> findByName(HouseSearchDto house) {
		return houseDao.findByName(house);
	}

	@Override
	public List<HouseDto> findByCity(HouseSearchDto house) {
		return houseDao.findByCity(house);
	}

	@Override
	public List<HouseDto> findByCityName(HouseSearchDto house) {
		return houseDao.findByCityName(house);
	}

	@Override
	public List<HouseDto> findByGugun(HouseSearchDto house) {
		return houseDao.findByGugun(house);
	}

	@Override
	public List<HouseDto> findByGugunName(HouseSearchDto house) {
		return houseDao.findByGugunName(house);
	}

	@Override
	public List<HouseDto> findByDong(HouseSearchDto house) {
		return houseDao.findByDong(house);
	}

	@Override
	public List<HouseDto> findByDongName(HouseSearchDto house) {
		return houseDao.findByDongName(house);
	}

	@Override
	public List<String> cityList() {
		return houseDao.cityList();
	}

	@Override
	public List<String> gugunList(String city) {
		return houseDao.gugunList(city);
	}

	@Override
	public List<String> dongList(String gugun) {
		return houseDao.dongList(gugun);
	}

	@Override
	public List<String> schoolList(String no) {
		return houseDao.schoolList(no);
	}

	@Override
	public boolean insertLike(LikeDto like) {
		houseDao.insertLike(like);
		return true;
	}

	@Override
	public boolean deleteLike(LikeDto unlike) {
		houseDao.deleteLike(unlike);
		return true;
	}

	@Override
	public List<HouseDto> showLike(String id) {
		return houseDao.showLike(id);
	}
}
