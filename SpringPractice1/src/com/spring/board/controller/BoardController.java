package com.spring.board.controller;


import java.io.IOException;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.spring.board.vo.BoardVO;

@Controller
public class BoardControl {
	
	
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
	public String list(HttpServletRequest req, Model model) {
		
		String board_event = req.getParameter("board_event");
		String board_category = req.getParameter("board_category");
		
		if(board_event != null && board_category != null) {
			
		int event = Integer.parseInt(board_event);
		int category = Integer.parseInt(board_category);
	
		BoardVO boardDTO = new BoardVO();
		boardDTO.setBoard_event(event);
		boardDTO.setBoard_category(category);
		
		List<BoardDTO> list = boardImple.selectAllByCate(boardDTO);
		
		for(BoardDTO dto : list) {
			
			dto.setBoard_date(dto.getBoard_date().substring(0, 16));
			
		}
		
		
		model.addAttribute("boardlist",list);
		model.addAttribute("board_event",board_event);
		model.addAttribute("board_category",board_category);
		}
		return "boardList";
	}
	

	
	//�Խñ� �Է�
	@RequestMapping("/boardInsert")
	public String processStep1(HttpServletRequest req,Model model) {
		String board_event = req.getParameter("board_event");
		String board_category = req.getParameter("board_category");
		
		model.addAttribute("board_event",board_event);
		model.addAttribute("board_category",board_category);
		
		return "boardForm";
	}
	
	
	
	@RequestMapping("/boardInsertOk")
	public void processStep2(@ModelAttribute BoardDTO boardDTO,HttpServletRequest req,
			HttpServletResponse resp,Model model) throws IOException {
			
			String u = req.getParameter("user_num");
			String e = req.getParameter("board_event");
			String c = req.getParameter("board_category");
			
			
			int usernum = Integer.parseInt(u);
			int event = Integer.parseInt(e);
			int cate = Integer.parseInt(c);
			
			boardDTO.setUser_num(usernum);
			boardDTO.setBoard_category(cate);
			boardDTO.setBoard_event(event);
		
			boardDAO.insertOne(boardDTO);
		
			
			resp.sendRedirect("/spring_project/boardList?board_event="+e+"&board_category="+c);
			
		}
		
		

	//�Խù� �����Ϻ���
	@RequestMapping("/boardDetail")
	public String detail(HttpServletRequest req,Model model) {
	
		if(req.getParameter("no") != null) {
	
		//��ȸ�� ����
		boardImple.updateHits(Integer.parseInt(req.getParameter("no")));
		
		//�Խù� ���� ��������
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