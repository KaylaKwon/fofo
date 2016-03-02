package org.fofo.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.board.dao.FreeBoardDAO;
import org.fofo.board.vo.FreeBoardList;
import org.fofo.board.vo.FreePost;

/*
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action){
			case "getBoard":
				doGetBoard(request, response);
				break;
			case "addBoard":
				doAddBoard(request, response);
				break;
			case "updateBoard":
				doUpdateBoard(request, response);
				break;
			case "listBoard":
				doListBoard(request, response);
				break;
		}
	}
	
	protected void doListBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FreeBoardDAO dao = new FreeBoardDAO();
		ArrayList<FreePost> list = dao.doListBoard();
		System.out.println("sdg");

		String returnURL = "freeboard/listAll.jsp";
		request.setAttribute("list", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);
	}
	
	public void doUpdateBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		FreeBoardDAO dao = new FreeBoardDAO();
//		FreePost freepost = new FreePost();
//		
//		freepost.setSeq(Integer.parseInt(request.getParameter("seq")));
//		freepost.setTitle(request.getParameter("title"));
//		freepost.setContent(request.getParameter("content"));
//		
//		dao.doUpdateBoard(freepost);
//		
//		response.sendRedirect("board?action=listBoard");
	}
	
	public void doAddBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		FreeBoardDAO dao = new FreeBoardDAO();
//		FreePost freepost = new FreePost();
//		
//		freepost.setTitle(request.getParameter("title"));
//		freepost.setWriter(request.getParameter("writer"));
//		freepost.setContent(request.getParameter("content"));
//		
//		dao.doAddBoard(freepost);
//		
//		response.sendRedirect("board?action=listBoard");
	}
	
	public void doGetBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		FreeBoardDAO dao = new FreeBoardDAO();
//		FreePost freepost = new FreePost();
//		freepost.setSeq(Integer.parseInt(request.getParameter("seq")));
//		dao.doGetBoard(freepost);
//		
//		String format = request.getParameter("format");
//		String returnURL = "getBoard.jsp";
//		if("json".equals(format)){
//			Gson gson = new Gson();
//			String json = gson.toJson(freepost);
//			request.setAttribute("result", json);
//			returnURL = "result.jsp";
//		}else{
//			request.setAttribute("board", freepost);
//		}
//		RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
//		dispatcher.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
}
