package org.fofo.noticeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.NoticeBoardDAO;
import org.fofo.board.vo.NoticePost;
import org.fofo.common.Controller;

public class RemovenBoardController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		NoticeBoardDAO dao = new NoticeBoardDAO();
		NoticePost noticepost = new NoticePost();
		
		noticepost.setnPostId(Integer.parseInt(request.getParameter("nPostId")));
		dao.doDeleteBoard(noticepost);
		
		return "/noticeboard.do";
	}

}