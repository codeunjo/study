package com.spring.board.dao;

import java.util.List;

import com.spring.board.vo.BoardVO;



public interface BoardImple {

	
	public List<BoardVO> selectAllByCate(BoardVO boardDTO);
	public List<BoardVO> selectAllMyBoard(int no);
	public void updateHits(int no);
	public void updateNom(int no);
	
}