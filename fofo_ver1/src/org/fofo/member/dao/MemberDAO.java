package org.fofo.member.dao;

import org.fofo.member.vo.Member;

import java.util.List;

public interface MemberDAO {
	
	public int doJoin(Member vo) throws Exception;
	
	public Member doLogin(Member vo) throws Exception;
	
	public int doIdCheck(Member vo) throws Exception;
	
	public void doLeave(Member vo) throws Exception;
	
	public Member listAll(Member vo) throws Exception;
	
}