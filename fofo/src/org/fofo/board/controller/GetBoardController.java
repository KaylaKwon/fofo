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
		
		//?��?��?��?��?��?��?�� seq 값을 받아 DB?�� ?���?
		//getBoard.jsp�? ?��?��?��?�� 보여주기
		FreeBoardDAO dao = new FreeBoardDAO();
		FreePost freepost = new FreePost();
		freepost.setfPostId(Integer.parseInt(request.getParameter("seq")));
		dao.doGetBoard(freepost);
		
		request.setAttribute("board", freepost);
		
		return "/getBoard.jsp";
	}

}
