package org.fofo.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.FreeBoardDAO;
import org.fofo.board.vo.FreePost;
import org.fofo.common.Controller;

public class GetBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//?Å¥?ùº?ù¥?ñ∏?ä∏?óê?Öì seq Í∞íÏùÑ Î∞õÏïÑ DB?óê ?ì±Î°?
		//getBoard.jspÎ°? ?ù¥?èô?ï¥?Ñú Î≥¥Ïó¨Ï£ºÍ∏∞
		FreeBoardDAO dao = new FreeBoardDAO();
		FreePost freepost = new FreePost();
		freepost.setfPostId(Integer.parseInt(request.getParameter("seq")));
		dao.doGetBoard(freepost);
		
		request.setAttribute("board", freepost);
		
		return "/getBoard.jsp";
	}

}
