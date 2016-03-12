package org.fofo.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fofo.project.vo.Project;
import org.fofo.common.JDBCUtil;

public class ProjectDAOImpl implements ProjectDAO {

	private static String addProjectSQL = "INSERT into project (userId , projectName, createDate, lastUpdate)"
									+"VALUES (123, ?, now(), now());";

	
	public ProjectDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAddProject(Project project) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(addProjectSQL);
			
//			stmt.setInt(1, project.getUserId());
			
			stmt.setString(1, project.getProjectName());
			System.out.println("project name: " + project.getProjectName());
//			stmt.setString(3, project.getProjectContent());
			
			
			int cnt = stmt.executeUpdate();
			if(cnt == 1){
				System.out.println("adding project had completed");
			}else{
				System.out.println("adding project had failed");
			}
			
		}catch(SQLException e){
			System.out.println("adding project occured an ERROR");
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		
	}

	@Override
	public void doDeleteProject(Project project) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Project> doListAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
