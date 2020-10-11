package com.spring.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.board.vo.BoardVO;;


public class BoardDAO implements DAO,BoardImple {
	
	SqlSession ss;
	
	public void setSs(SqlSession ss) {
		this.ss = ss;
	}

	@Override
	public List<BoardVO> selectAll() {
	
	
	
		return ss.selectList("selectAllBoard");

	}
	
	

	@Override
	public void insertOne(Object obj) {
		
	ss.insert("insertOneBoard", (BoardDTO) obj);
		
	}
	
	@Override
	public Object selectOne(int no) {
		
		return (BoardDTO)ss.selectOne("selectOneBoard", no);
	}
	
	
	
	

	@Override
	public void updateOne(Object obj) {
		ss.update("updateBoard", (BoardDTO) obj);
		
	}

	@Override
	public void deleteOne(int no) {
		ss.delete("deleteBoard", no);
		
	}

	@Override
	public List<BoardDTO> selectAllByCate(BoardDTO boardDTO) {
		
		
		return ss.selectList("selectBoardByCate",boardDTO);
	}

	@Override
	public List<BoardDTO> selectAllMyBoard(int no) {
	
		return ss.selectList("selectAllMyBoard", no);
	}

	@Override
	public void updateHits(int no) {
		ss.update("updateHits", no);
	}

	@Override
	public void updateNom(int no) {
		ss.update("updateNom",no);
		
	}



	
	
	
}
