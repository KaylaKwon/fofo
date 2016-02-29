package org.fofo.member.dao;

import org.fofo.member.vo.Member;

import java.util.List;

public interface MemberDAO {
	
	public void doJoin(Member vo) throws Exception;
	
	public Member doLogin(Member vo) throws Exception;
	
	public void doIdCheck(Member vo) throws Exception;
	
	public void doLeave(Member vo) throws Exception;
	
	public List<Member> listAll() throws Exception;
	
}