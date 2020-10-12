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
		
	ss.insert("insertOneBoard", (BoardVO) obj);
		
	}
	
	@Override
	public Object selectOne(int no) {
		
		return (BoardVO)ss.selectOne("selectOneBoard", no);
	}
	
	
	
	

	@Override
	public void updateOne(Object obj) {
		ss.update("updateBoard", (BoardVO) obj);
		
	}

	@Override
	public void deleteOne(int no) {
		ss.delete("deleteBoard", no);
		
	}

	@Override
	public List<BoardVO> selectAllByCate(BoardVO boardDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectAllMyBoard(int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateHits(int no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNom(int no) {
		// TODO Auto-generated method stub
		
	}



	
	
	
}
