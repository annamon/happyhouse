package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.BoardDao;
import com.ssafy.happyhouse.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean writeBoard(BoardDto board) {
		boardDao.writeBoard(board);
		return true;
	}

	@Override
	public boolean updateBoard(BoardDto board) {
		boardDao.updateBoard(board);
		return true;
	}

	@Override
	public boolean deleteBoard(int no) {
		boardDao.deleteBoard(no);
		return false;
	}

	@Override
	public List<BoardDto> notice() {
		return boardDao.notice();
	}

	@Override
	public List<BoardDto> openBoard() {
		return boardDao.openBoard();
	}

	@Override
	public BoardDto detailBoard(int no) {
		return boardDao.detailBoard(no);
	}

}
