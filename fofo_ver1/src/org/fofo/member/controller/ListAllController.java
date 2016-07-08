package org.fofo.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fofo.common.Controller;
import org.fofo.member.dao.MemberDAOImpl;
import org.fofo.member.vo.Member;

public class ListAllController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String returnURL = "/user/profile.jsp";
		
		MemberDAOImpl dao = new MemberDAOImpl();
		Member vo = new Member();
		HttpSession session=request.getSession();
		String email=(String) session.getAttribute("email");
		System.out.println("세션:"+email);
		vo.setuEmail(email);
		
		try {
			vo=dao.listAll(vo);
			request.setAttribute("data", vo);
			request.setAttribute("a", "wwwww");
			System.out.println(vo.getuEmail());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnURL;
	}

}
