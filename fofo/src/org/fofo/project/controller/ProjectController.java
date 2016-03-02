package org.fofo.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.common.Controller;

public class ProjectController implements Controller{

	public ProjectController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String returnURL = "/project/project.jsp";
		
//		BoardDAO dao = new BoardDAO();
//		Board board = new Board();		
//		board.setSeq(Integer.parseInt(request.getParameter("seq")));
//		dao.doReadBoard(board);
//		
//		request.setAttribute("board", board);
		
		
		return returnURL;
	}

}
