package com.spring.board.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;

import com.spring.board.dao.BoardImple;
import com.spring.board.dao.DAO;
import com.spring.board.vo.BoardVO;

@Controller
public class BoardController {
	
	
	@Autowired
	DAO boardDAO;	
	
	
	@Autowired
	BoardImple boardImple;
	
	public void setDao(DAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	
	

	public void setBoardImple(BoardImple boardImple) {
		this.boardImple = boardImple;
	}


	@RequestMapping(value="/boardList")
	public String list(HttpServletBean req, Model model) {
		
		String board_event = req.getParameter("board_event");
		String board_category = req.getParameter("board_category");
		
		if(board_event != null && board_category != null) {
			
		int event = Integer.parseInt(board_event);
		int category = Integer.parseInt(board_category);
	
		BoardVO boardDTO = new BoardVO();
		boardDTO.setBoard_event(event);
		boardDTO.setBoard_category(category);
		
		List<BoardVO> list = boardImple.selectAllByCate(boardDTO);
		
		for(BoardVO dto : list) {
			
			dto.setBoard_date(dto.getBoard_date().substring(0, 16));
			
		}
		
		
		model.addAttribute("boardlist",list);
		model.addAttribute("board_event",board_event);
		model.addAttribute("board_category",board_category);
		}
		return "boardList";
	}
	

	
	//게시글 입력
	@RequestMapping("/boardInsert")
	public String processStep1(HttpServletRequest req,Model model) {
		String board_event = req.getParameter("board_event");
		String board_category = req.getParameter("board_category");
		
		model.addAttribute("board_event",board_event);
		model.addAttribute("board_category",board_category);
		
		return "boardForm";
	}
	
	
	

	//게시물 디테일보기
	@RequestMapping("/boardDetail")
	public String detail(HttpServletRequest req,Model model) {
	
		if(req.getParameter("no") != null) {
	
		//조회수 증가
		boardImple.updateHits(Integer.parseInt(req.getParameter("no")));
		
		//게시물 정보 가져오기
		model.addAttribute("boardDetail", boardDAO.selectOne(Integer.parseInt(req.getParameter("no"))));
		
		String board_event = req.getParameter("board_event");
		String board_category = req.getParameter("board_category");
		
		
		model.addAttribute("board_event",board_event);
		model.addAttribute("board_category",board_category);
	
		
		return "boardDetail";
		
		}else	
			return "main";
	}
	
	
	
	@RequestMapping("/boardModify")
	public String modify(HttpServletRequest req,Model model) {

		
	model.addAttribute("boardModify", boardDAO.selectOne(Integer.parseInt(req.getParameter("no"))));

		return "boardModify";
	}
	
	
	

	


}