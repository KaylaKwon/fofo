package org.fofo.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberDispatcherServlet
 */
@WebServlet("/MemberDispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring( uri.lastIndexOf("/"));
		System.out.println("connected");
		System.out.println("uri : " + uri);
		System.out.println("path: " + path);
		
		String returnURL = "/home.jsp";	// hashmap에 없는 주소를 요청할 때 보낼 주소
		
		HandlerMapping mappings = new HandlerMapping();	//분기시키는 애
		Controller controller = mappings.getController(path);
		
		
		if(controller != null){
			returnURL = controller.handleRequest(request, response);
		}
		
		if("/login.jsp".equals(returnURL)){
			response.sendRedirect("login.jsp");
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
			dispatcher.forward(request, response);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
