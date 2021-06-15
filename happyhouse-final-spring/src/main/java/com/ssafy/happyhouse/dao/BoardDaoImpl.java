package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.happyhouse.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	private String ns = "com.ssafy.happyhouse.dao.BoardMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void writeBoard(BoardDto board) {
		sqlSession.insert(ns+"writeBoard", board);
	}

	@Override
	public void updateBoard(BoardDto board) {
		sqlSession.update(ns+"updateBoard", board);
	}

	@Override
	public void deleteBoard(int no) {
		sqlSession.delete(ns+"deleteBoard", no);
	}

	@Override
	public List<BoardDto> notice() {
		return sqlSession.selectList(ns+"notice");
	}

	@Override
	public List<BoardDto> openBoard() {
		return sqlSession.selectList(ns+"openBoard");
	}

	@Override
	public BoardDto detailBoard(int no) {
		return sqlSession.selectOne(ns+"detailBoard", no);
	}

}
