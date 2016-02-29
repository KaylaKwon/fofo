package org.fofo.project.dao;

import java.util.ArrayList;

import org.fofo.project.vo.Project;

public interface ProjectDAO {

	public void doAddProject(Project project) throws Exception;
	
	public void doDeleteProject(Project project) throws Exception;
	
	public ArrayList<Project> doListAll() throws Exception;

}
