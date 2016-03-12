package org.fofo.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fofo.project.vo.Project;
import org.fofo.common.JDBCUtil;

public class ProjectDAOImpl implements ProjectDAO {

	private static String addProjectSQL = "INSERT INTO board(title, userId)"
											+ "VALUES(?, ?);";
	
	
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
			stmt.setString(1, project.getProjectTitle());
			stmt.setInt(2, project.getUserId());
			
			
			int cnt = stmt.executeUpdate();	//prepareStatement에서 이미 실행됐기때문에 빈거
			if(cnt == 1){
				System.out.println("adding board had successed");
			}else{
				System.out.println("adding board had failed");
			}
			
		}catch(SQLException e){
			System.out.println("adding board occured an ERROR");
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
