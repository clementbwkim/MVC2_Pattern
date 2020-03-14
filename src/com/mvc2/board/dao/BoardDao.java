package com.mvc2.board.dao;

import java.util.ArrayList;

import com.mvc2.board.vo.BoardVO;

public interface BoardDao {
	
	public int insertBoard(BoardVO _bvo);
	public ArrayList<BoardVO> selectBoard();
	public int updateBoard(BoardVO _bvo);
	public ArrayList<BoardVO> searchBoard(BoardVO _bvo);
	public int deleteBoard(BoardVO _bvo);
}
