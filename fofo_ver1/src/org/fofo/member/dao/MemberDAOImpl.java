package org.fofo.member.dao;

import java.util.List;

import org.fofo.member.vo.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fofo.common.JDBCUtil;

public class MemberDAOImpl implements MemberDAO{
	
	private static String doJoinSQL = "INSERT INTO user(uName, uEmail, uPW) VALUES(?, ?, ?)";
	private static String doLoginSQL = "SELECT * FROM user WHERE uEmail = ?";

	private static String doIdCheckSQL = "SELECT * FROM user WHERE uEmail = ?";
	public MemberDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int doJoin(Member vo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		System.out.println("vo ->"+vo.getUName()+vo.getUEmail()+vo.getUPW());
		int result=0;
		int joinResult=0;
		result=doIdCheck(vo);
		if(result==1){
			try{
				
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(doJoinSQL);
				stmt.setString(1, vo.getUName());
				stmt.setString(2, vo.getUEmail());
				stmt.setString(3, vo.getUPW());
				
				int cnt = stmt.executeUpdate();	
				if(cnt == 1){
					System.out.println("joining had successed");
				}else{
					System.out.println("joining had failed");
				}
				
			}catch(SQLException e){
				System.out.println("joining occured an ERROR");
				e.printStackTrace();
			}finally{
				JDBCUtil.close(stmt, conn);
			}
			joinResult=1;
		}else{
			System.out.println("??");
		
		}
		return joinResult;

	}

	@Override
	public Member doLogin(Member vo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(doLoginSQL);
			stmt.setString(1, vo.getUEmail());
			String pw=vo.getUPW();
			ResultSet cnt = stmt.executeQuery();	
			if(cnt.next()){
				if(cnt.getString("uPW")!=null&&cnt.getString("uPW").equals(pw)){
					//�쇱튂�섎㈃
					vo.setUName(cnt.getString("uName"));
					System.out.println("Login had successed ");
				
				}else{
					System.out.println("Login had failed");
				}
			}
			
			
		}catch(SQLException e){
			System.out.println("Login occured an ERROR");
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		return vo;
	}

	@Override
	public int doIdCheck(Member vo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(doIdCheckSQL);
			stmt.setString(1, vo.getUEmail());
			
			
			ResultSet cnt = stmt.executeQuery();	
			if(cnt.next()){
				
					System.out.println("중복입니다.");
					result=-1;
				
			}else{
				System.out.println("중복이 아닙니다.");

				result=1;
			}
			
		}catch(SQLException e){
			System.out.println("joining occured an ERROR");
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		return result;
	}

	@Override
	public void doLeave(Member vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Member> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
