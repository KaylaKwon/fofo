package org.fofo.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fofo.common.Controller;
import org.fofo.member.vo.Member;
import org.fofo.project.dao.ProjectDAOImpl;
import org.fofo.project.vo.Project;


public class LoadProjectListController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String returnURL = "/project/project.jsp";
		
		ProjectDAOImpl dao = new ProjectDAOImpl();
		
		Project project = new Project();
		Member member = new Member();

		member.setUserId(123);
		try{
			
			/*project = dao.doGetProjectContent(project, member);

			request.setAttribute("projectContent", project.getProjectContent());
			
			System.out.println("selected project content: " + project.getProjectContent());*/
			
			
			/*ArrayList<Project> list = dao.doListAll(member);

			request.setAttribute("projectList", list);
			
			for(Project i : list){
				System.out.println(i.getProjectName());
			}*/

			
		}catch(Exception e){
			
		}finally{
			
			
		}
		
		
		
		
		
		return returnURL;
	}

}
