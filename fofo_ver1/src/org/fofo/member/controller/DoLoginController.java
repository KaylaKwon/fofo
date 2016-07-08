package org.fofo.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.fofo.common.Controller;
import org.fofo.member.dao.MemberDAOImpl;
import org.fofo.member.vo.Member;

public class DoLoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String returnURL = "/home.jsp";
		
		MemberDAOImpl dao = new MemberDAOImpl();
		Member vo = new Member();
		
		vo.setuEmail(request.getParameter("email"));
		vo.setuPw(request.getParameter("pw"));
		
		try {
			vo=dao.doLogin(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(vo.getuName()!= null){
			//세션
			HttpSession session = request.getSession();
			session.setAttribute("name", vo.getuName());
			session.setAttribute("email", vo.getuEmail());
			session.setAttribute("uid", vo.getUserId());
			System.out.println("login!");
		}else{
			request.setAttribute("error", "Invalid email or password");
			returnURL="/user/login.jsp";
		}
		return returnURL;
	}

}
