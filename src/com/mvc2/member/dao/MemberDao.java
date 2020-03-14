package com.mvc2.member.dao;

import java.util.ArrayList;

import com.mvc2.member.vo.MemberVO;

public interface MemberDao {

	public int insertMember(MemberVO _mvo);
	public int updateMmber(MemberVO _mvo);
	public int deleteMember(MemberVO _mvo);
	public ArrayList<MemberVO> selectMember();
	public ArrayList<MemberVO> searchMember(MemberVO _mvo);
	public ArrayList<MemberVO> loginMember(MemberVO _mvo);
	public int idCheck(MemberVO _mvo);
	
}
