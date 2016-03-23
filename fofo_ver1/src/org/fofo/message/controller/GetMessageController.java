package org.fofo.message.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.vo.FreeComment;
import org.fofo.common.Controller;
import org.fofo.message.dao.MessageDAO;
import org.fofo.message.vo.Message;

public class GetMessageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MessageDAO dao = new MessageDAO();
		Message message = new Message();
		
		int SuserId = Integer.parseInt(request.getParameter("SuserId"));
		ArrayList<Message> mlist = dao.doGetMessage(SuserId);
		
		request.setAttribute("mlist", mlist);
		request.setAttribute("SuserId", SuserId);
		
		return "/message/messageRead.jsp";
	}
}
