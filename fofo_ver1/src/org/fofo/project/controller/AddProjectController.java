package org.fofo.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.common.Controller;
import org.fofo.project.dao.ProjectDAOImpl;
import org.fofo.project.vo.Project;


public class AddProjectController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String returnURL = "/project/project.jsp";
		
		ProjectDAOImpl dao = new ProjectDAOImpl();
		Project project = new Project();
		
		request.setCharacterEncoding("utf-8");
		
		
		
		String method = request.getParameter("method");
		System.out.println("method: " + method);
		if("addNewProject".equals(method)){
			System.out.println("get project editor controller");
		}
		
		
		
		
		
//		project.setProjectName(request.getParameter("addProjectName"));
//		project.setUserId(Integer.parseInt(request.getParameter("userId")));
//		project.setUserId(Integer.parseInt(request.getParameter("userId")));
//		System.out.println("projectName in controller" + project.getProjectName());
		
/*		try {
			dao.doAddProject(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		return returnURL;
	}

}
