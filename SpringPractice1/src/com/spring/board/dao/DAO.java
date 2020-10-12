package com.spring.board.dao;

import java.util.List;

import com.spring.board.vo.BoardVO;


public interface DAO {
	

	public List<BoardVO> selectAll();
	public void insertOne(Object obj);
	public Object selectOne(int no);
	public void updateOne(Object obj);
	public void deleteOne(int no);
	


}