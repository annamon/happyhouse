package com.ssafy.happyhouse.controller;

import java.util.List;

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

import com.ssafy.happyhouse.dto.BoardDto;
import com.ssafy.happyhouse.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8080/happyhouse_final/swagger-ui.html
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/happyhouse/board")
@Api(value="HappyHouse_final", description="HappyHouse Resouces Management 2021")
public class BoardController {
	
	public static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private BoardService boardService;
	
	// 성공 여부에 따라 'success' / 'fail'
	@ApiOperation(value = "새 게시글을 등록한다.", response = String.class)
	@PostMapping("/writeBoard")
	public ResponseEntity<String> writeBoard(@RequestBody BoardDto board){
		logger.debug("---- writeBoard 호출----");
		if(boardService.writeBoard(board)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "글번호에 해당하는 게시글을 수정한다.", response = String.class)
	@PutMapping("{no}")
	public ResponseEntity<String> updateBoard(@RequestBody BoardDto board) {
		logger.debug("---- updateBoard 호출----");
		if (boardService.updateBoard(board)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
	@ApiOperation(value = "글번호에 해당하는 게시글을 삭제한다.", response = String.class)
	@DeleteMapping("{no}")
	public ResponseEntity<String> deleteGesipan(@PathVariable int no) {
		logger.debug("---- deleteBoard 호출----");
		if (boardService.deleteBoard(no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "공지사항 글을 반환한다.", response = List.class)
	@GetMapping("/notice")
	public ResponseEntity<List<BoardDto>> notice(){
		logger.debug("---- notice 호출 ----");
		return new ResponseEntity<List<BoardDto>>(boardService.notice(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "자유게시판 글을 반환한다.", response = List.class)
	@GetMapping("/")
	public ResponseEntity<List<BoardDto>> openBoard(){
		logger.debug("---- openBoard 호출 ----");
		return new ResponseEntity<List<BoardDto>>(boardService.openBoard(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "id에 해당하는 게시판 글을 보여준다.", response = BoardDto.class)
	@GetMapping("/{no}")
	public BoardDto detailBoard(@PathVariable int no) {
		logger.debug("---- detailBoard 호출 : " + no + "번 게시글 ----");
		return boardService.detailBoard(no);
	}
}
