package org.fofo.member.dao;

import org.fofo.member.vo.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.fofo.common.JDBCUtil;

public class MemberDAOImpl implements MemberDAO{
	
	private static String doJoinSQL = "INSERT INTO user(uName, uEmail, uPw, uJoinDate) VALUES(?, ?, ?, ?)";
	private static String doLoginSQL = "SELECT * FROM user WHERE uEmail = ?";

	private static String doIdCheckSQL = "SELECT * FROM user WHERE uEmail = ?";

	private static String doListAllSQL = "SELECT * FROM user WHERE uEmail = ?";
	public MemberDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int doJoin(Member vo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		int result=0;
		int joinResult=0;
		result=doIdCheck(vo);
		Date dNow = new Date( );
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current Date: " + ft.format(dNow));
	
		if(result==1){
			try{
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(doJoinSQL);
				stmt.setString(1, vo.getUName());
				stmt.setString(2, vo.getUEmail());
				stmt.setString(3, vo.getUPW());
				stmt.setString(4,ft.format(dNow));
				
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
				if(cnt.getString("uPw")!=null&&cnt.getString("uPw").equals(pw)){
					//일치하면
					vo.setUName(cnt.getString("uName"));
					vo.setUserId(cnt.getInt("uId"));
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
				
					System.out.println("중복");
					result=-1;
				
			}else{
				System.out.println("안중복");

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
	public Member listAll(Member vo) throws Exception {
		// TODO Auto-generated method stub\
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet cnt=null;
		System.out.println("listall실행");
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(doListAllSQL);
			stmt.setString(1, vo.getUEmail());
			cnt = stmt.executeQuery();	
			
			if(cnt.next()){

				vo.setUEmail(cnt.getString("uEmail"));
				vo.setUName(cnt.getString("uName"));
				vo.setUNickname(cnt.getString("uNickname"));
				vo.setUBirth(cnt.getString("uBirth"));
				vo.setUSchoolIds(cnt.getString("uSchoolIds"));
				vo.setUSchoolNum(cnt.getInt("uSkillNum"));
				vo.setUCareerIds(cnt.getString("uCareerIds"));
				vo.setUAwardNum(cnt.getInt("uAwardNum"));
				vo.setUAwardIds(cnt.getString("uAwardIds"));
				vo.setULanguageNum(cnt.getInt("uLanguageNum"));
				vo.setULanguageIds(cnt.getString("uLanguageIds"));
				//겟 리스트
				//스쿨,경력 ... 리스트 받아
			}
			
			
		}catch(SQLException e){
			System.out.println("ListAll occured an ERROR");
		}finally{
			JDBCUtil.close(stmt, conn);
		}
		
		return vo;
	}


}
