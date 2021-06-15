package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseSearchDto;
import com.ssafy.happyhouse.dto.LikeDto;

public interface HouseDao {

	List<HouseDto> findAll();
	List<HouseDto> findByName(HouseSearchDto house);

	List<HouseDto> findByCity(HouseSearchDto house);
	List<HouseDto> findByCityName(HouseSearchDto house);

	List<HouseDto> findByGugun(HouseSearchDto house);
	List<HouseDto> findByGugunName(HouseSearchDto house);

	List<HouseDto> findByDong(HouseSearchDto house);
	List<HouseDto> findByDongName(HouseSearchDto house);
	
	List<String> cityList();
	List<String> gugunList(String city);
	List<String> dongList(String gugun);
	
	List<String> schoolList(String no);
	
	void insertLike(LikeDto like);
	void deleteLike(LikeDto unlike);
	List<HouseDto> showLike(String id);
	
	
	

}
