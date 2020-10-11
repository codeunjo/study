package com.spring.board.vo;

import java.sql.Date;

public class BoardVO {

	private int board_no;
	private String title;
	private String contents;
	private Date write_dt;
	private String write_id;
	private int hits;

	public BoardVO() {
		
	}

	public BoardVO(int board_no, String title, String contents, Date write_dt, String write_id, int hits) {
		super();
		this.board_no = board_no;
		this.title = title;
		this.contents = contents;
		this.write_dt = write_dt;
		this.write_id = write_id;
		this.hits = hits;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getWrite_dt() {
		return write_dt;
	}

	public void setWrite_dt(Date write_dt) {
		this.write_dt = write_dt;
	}

	public String getWrite_id() {
		return write_id;
	}

	public void setWrite_id(String write_id) {
		this.write_id = write_id;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}
	
	
	
}
