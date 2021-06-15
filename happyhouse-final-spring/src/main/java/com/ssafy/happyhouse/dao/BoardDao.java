package com.ssafy.happyhouse.dao;

import java.util.List;

import com.ssafy.happyhouse.dto.BoardDto;

public interface BoardDao {

	void writeBoard(BoardDto board);
	void updateBoard(BoardDto board);
	void deleteBoard(int no);
	List<BoardDto> notice();
	List<BoardDto> openBoard();
	
	BoardDto detailBoard(int no);

}
