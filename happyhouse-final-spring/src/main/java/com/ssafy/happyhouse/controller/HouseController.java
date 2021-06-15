package com.ssafy.happyhouse.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.HouseDto;
import com.ssafy.happyhouse.dto.HouseSearchDto;
import com.ssafy.happyhouse.dto.LikeDto;
import com.ssafy.happyhouse.service.HouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8100/happyhouse_final/swagger-ui.html
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/happyhouse/house")
@Api(value="HappyHouse_final", description="HappyHouse Resouces Management 2021")
public class HouseController {
	
	public static final Logger logger = LoggerFactory.getLogger(HouseController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private HouseService houseService;
	
	@ApiOperation(value = "시 군 구 검색 조건에 따라 검색 결과를 반환한다.", response = HouseDto.class)
	@PostMapping("/search")
	public List<HouseDto> searchHouse(@RequestBody HouseSearchDto house){
		logger.debug("---- searchHouse 호출 ----");
		System.out.println(house);
		if(house.getCity().equals("") && house.getGugun().equals("") && house.getDong().equals("")) {
			if(house.getWord().equals("")) { 
				return houseService.findAll();			//x 
			}else {
				return houseService.findByName(house);  //검색어o
			}
		}
		else if(!house.getCity().equals("") && house.getGugun().equals("") && house.getDong().equals("")) {
			if(house.getWord().equals("")) {
				return houseService.findByCity(house); 		//시o
			}else {					
				return houseService.findByCityName(house);	//시o 검색어o
			}
		}
		else if(!house.getCity().equals("") && !house.getGugun().equals("") && house.getDong().equals("")) {
			if(house.getWord().equals("")) {
				return houseService.findByGugun(house); 	//시o 구o
			}else {		
				return houseService.findByGugunName(house);	//시o 구o 검색어o
			}
		}
		else if(!house.getCity().equals("") && !house.getGugun().equals("") && !house.getDong().equals("")) {	
			System.out.println("yes");
			if(house.getWord().equals("")) {
				return houseService.findByDong(house); 		//시o 구o 동o
			}else {		
				return houseService.findByDongName(house);	//시o 구o 동o 검색어o
			}
		}
		else return null;
	}
	
	@ApiOperation(value = "시 목록을 반환한다.", response = List.class)
	@GetMapping("/city")
	public List<String> cityList(){
		logger.debug("---- cityList 호출 ----");
		return houseService.cityList();
	}
	
	@ApiOperation(value = "시 선택에 따른 구 목록을 반환한다.", response = List.class)
	@GetMapping("/gugun/{city}")
	public List<String> gugunList(@PathVariable String city){
		logger.debug("---- gugunList 호출 ----");
		return houseService.gugunList(city);
	}
	
	@ApiOperation(value = "구 선택에 따른 동 목록을 반환한다.", response = List.class)
	@GetMapping("/dong/{gugun}")
	public List<String> gondList(@PathVariable String gugun){
		logger.debug("---- gugunList 호출 ----");
		return houseService.dongList(gugun);
	}
	
	@ApiOperation(value = "아파트 no별로 학군 반환한다.", response = List.class)
	@GetMapping("/school/{no}")
	public List<String> schoolList(@PathVariable String no){
		logger.debug("---- schoolList 호출 ----");
		return houseService.schoolList(no);
	}
	
	@ApiOperation(value = "user id별로 원하는 아파트 no를 찜목록에 저장한다.", response = String.class)
	@PostMapping("/like")
	public String insertLike(@RequestBody LikeDto like){
		logger.debug("---- like 호출 ----");
		if(houseService.insertLike(like)) {			
			return SUCCESS;
		}
		return FAIL;
	}
	
	@ApiOperation(value = "user id별 찜목록에서 아파트를 삭제한다.", response = String.class)
	@DeleteMapping("/unlike")
	public String deleteLike(@RequestBody LikeDto unlike){
		logger.debug("---- like 호출 ----");
		if(houseService.deleteLike(unlike)) {			
			return SUCCESS;
		}
		return FAIL;
	}
	
	@ApiOperation(value = "user id별로 찜목록을 반환한다.", response = HouseDto.class)
	@GetMapping("/like/{id}")
	public List<HouseDto> showLike(@PathVariable String id){
		logger.debug("---- showLike 호출 ----");
		return houseService.showLike(id);
	}
}
