package org.fofo.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fofo.project.vo.Project;

import org.fofo.common.JDBCUtil;
import org.fofo.member.vo.Member;

public class ProjectDAOImpl implements ProjectDAO {

	private static String addProjectSQL = "INSERT into project (userId , projectName, createDate, lastUpdate)"
									+"VALUES (123, ?, now(), now());";

	private static String loadProjectListSQL = "SELECT projectName, lastUpdate "
												+"FROM project "
												+"WHERE userId = ?;";
	
	private static String loadProjectContentSQL = "SELECT projectContent "
												+"FROM project"
												+"WHERE userId = ?, projectName = ?;";
	
	public ProjectDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Project doGetProjectContent(Project project, Member member) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		
		Project pjt = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(loadProjectContentSQL);
			
			stmt.setInt(1, member.getUserId());
			stmt.setString(2, project.getProjectName());
			
			rst = stmt.executeQuery();
			
			pjt = new Project();
			pjt.setProjectContent(rst.getString("projectContent"));
			
		}catch(SQLException e){
			System.out.println("adding project occured an ERROR");
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		return pjt;
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
	public ArrayList<Project> doListAll(Member member) throws Exception {
		
		ArrayList<Project> list = new ArrayList<Project>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		Project project = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(loadProjectListSQL);
			
			stmt.setInt(1, 123);
			
			rst = stmt.executeQuery();	
			
			while(rst.next()){
				project = new Project();
				project.setProjectName(rst.getString("projectName"));
				project.setLastUpdate(rst.getString("lastUpdate"));
				
//				System.out.println(project.getProjectName());
				
				list.add(project);
				
			}
					
		}catch(SQLException e){
			System.out.println("failed: " + e);
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		return list;
		
	}

	

}
