package org.fofo.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.common.Controller;
import org.fofo.member.dao.MemberDAOImpl;
import org.fofo.member.vo.Member;

public class DoJoinController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String returnURL = "/home.jsp";
		
		MemberDAOImpl dao = new MemberDAOImpl();
		Member vo = new Member();
		
		vo.setUName(request.getParameter("name"));
		vo.setUEmail(request.getParameter("email"));
		vo.setUPW(request.getParameter("pw"));

		try {
			dao.doJoin(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnURL;
	}

}
