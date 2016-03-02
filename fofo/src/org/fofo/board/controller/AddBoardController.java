package org.fofo.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.FreeBoardDAO;
import org.fofo.board.vo.FreePost;
import org.fofo.common.Controller;

public class AddBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FreeBoardDAO dao = new FreeBoardDAO();
		FreePost freepost = new FreePost();
		
		freepost.setfPostTitle(request.getParameter("title"));
		freepost.setfPostContent(request.getParameter("writer"));
		freepost.setUserId(Integer.parseInt(request.getParameter("content")));
		
		dao.doAddBoard(freepost);
		
		return "/getBoardList.do";
	}

}
