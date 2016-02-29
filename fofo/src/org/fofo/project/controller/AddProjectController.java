package org.fofo.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.common.Controller;
import org.fofo.project.dao.ProjectDAOImpl;
import org.fofo.project.vo.Project;


public class AddProjectController implements Controller{

	public AddProjectController() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String returnURL = "/project.do";
		
		ProjectDAOImpl dao = new ProjectDAOImpl();
		Project project = new Project();
		
		project.setProjectTitle(request.getParameter("title"));
		project.setUserId(Integer.parseInt(request.getParameter("title")));

		
		try {
			dao.doAddProject(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
