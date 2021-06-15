package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.BoardDto;

public interface BoardService {

	boolean writeBoard(BoardDto board);
	boolean updateBoard(BoardDto board);
	boolean deleteBoard(int no);
	List<BoardDto> notice();
	List<BoardDto> openBoard();
	
	BoardDto detailBoard(int no);

}
