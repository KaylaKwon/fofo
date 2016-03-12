package org.fofo.freecomment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.FreeBoardDAO;
import org.fofo.board.dao.FreeCommentDAO;
import org.fofo.board.vo.FreeComment;
import org.fofo.board.vo.FreePost;
import org.fofo.common.Controller;

public class ModifyViewCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		FreeComment freecomment = new FreeComment();
		
		request.setCharacterEncoding("utf-8");
		freecomment.setfPostId(Integer.parseInt(request.getParameter("fPostId")));
		freecomment.setfCommentId(Integer.parseInt(request.getParameter("fmodifyCId")));
		
		request.setAttribute("fmodifyCId", freecomment.getfCommentId());
		request.setAttribute("fPostId", freecomment.getfPostId());
		
		return "/getfreeboard.do";
	}
}
