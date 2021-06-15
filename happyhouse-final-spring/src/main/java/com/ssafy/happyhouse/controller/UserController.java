package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.UserDto;
import com.ssafy.happyhouse.help.LoginAlert;
import com.ssafy.happyhouse.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8100/happyhouse_final/swagger-ui.html
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/happyhouse")
@Api(value="HappyHouse_final", description="HappyHouse Resouces Management 2021")
public class UserController {

	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private UserService userService;
	
	// --------------- user ---------------
	// 성공 여부에 따라 'success' / 'fail'
	@ApiOperation(value = "회원가입시 아이디 중복을 검사한다.", response = String.class)
	@PostMapping("/joinUser/checkID/{id}")
	public String checkID(@PathVariable String id){
		logger.debug("---- checkID 호출----");
		UserDto existUser = userService.checkID(id);
		if(existUser==null) {
			return "사용가능한 아이디입니다.";
		}
		return "사용할 수 없는 아이디입니다.";
	}
	
	@ApiOperation(value = "신규 회원의 정보를 등록한다.", response = String.class)
	@PostMapping("/joinUser")
	public ResponseEntity<String> joinUser(@RequestBody UserDto user) {
		logger.debug("---- joinUser 호출----");
		if (userService.joinUser(user)) {
			logger.debug("---- 회원가입 :" + user);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원의 정보를 수정한다.", response = String.class)
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<String> updateUser(@RequestBody UserDto user){
		logger.debug("---- updateUser 호출----");
		if (userService.updateUser(user)) {
			logger.debug("---- 정보수정 :" + user);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "회원의 정보를 삭제한다.(탈퇴)", response = String.class)
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id){
		logger.debug("---- deleteUser 호출----");
		if (userService.deleteUser(id)) {
			logger.debug("---- 정보삭제 / 회원 아이디 :" + id);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="회원 한 명의 정보를 가져온다.", response = UserDto.class)
	@PostMapping("/detailUser")
	public UserDto detailUser(@RequestBody UserDto user){
		logger.debug("---- detailUser 호출 ----");
		return userService.detailUser(user.getId());
	}
	
	
	
	@ApiOperation(value = "아이디와 비밀번호 힌트를 입력받아 비밀번호를 찾는다.", response = String.class)
	@PostMapping("/findPassword")
	public ResponseEntity<String> findPassword(@RequestBody UserDto user){
		logger.debug("---- findPassword 호출----");
		String password = userService.findPassword(user);
		return new ResponseEntity<String>(password, HttpStatus.OK);
	}
	
	@ApiOperation(value = "아이디와 비밀번호를 입력받아 로그인한다.", response = String.class)
	@PostMapping("/login")
	public LoginAlert login(@RequestBody UserDto user,  HttpSession session){
		logger.debug("---- login 호출 ----");
		UserDto loginUser = userService.login(user);
		LoginAlert alert;
		if(loginUser != null) {
			logger.debug("---- 로그인한 사람 : "+ loginUser.getId());
			alert = new LoginAlert(SUCCESS, loginUser.getId(), loginUser.getName(), true);
			return alert;
		}else {
			alert = new LoginAlert(FAIL);
			return alert;
		}
	}
	
//	@ApiOperation(value = "로그아웃 한다.", response = String.class)
//	@GetMapping("/logout")
//	public ResponseEntity<String> logout(HttpSession session){
//		logger.debug("---- logout 호출 ----");
//		session.invalidate();
//		return new ResponseEntity<String>(SUCCESS, HttpStatus.NO_CONTENT);
//	}

	
	
	// ----------- admin : ssafy -----------
	@ApiOperation(value="전체 회원 목록을 가져온다.", response = List.class)
	@GetMapping("/admin/allUser")
	public List<UserDto> allUser(){
		logger.debug("---- admin : allUser 호출 ----");
		return userService.allUser();
	}
	
	@ApiOperation(value="검색한 아이디의 회원 정보를 반환한다.", response = List.class)
	@GetMapping("/admin/findByID/{id}")
	public List<UserDto> findByID(@PathVariable String id){
		logger.debug("---- admin : findByID 호출 ----");
		List<UserDto> users = userService.findByID(id);
		return users;
	}
	
	
}
