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
	
	private static String doJoinSQL = "INSERT INTO user(nickname, email, pw) VALUES(?, ?, ?)";
	private static String doLoginSQL = "SELECT * FROM user WHERE email = ?";

	private static String doIdCheckSQL = "SELECT * FROM user WHERE email = ?";

	private static String doListAllSQL = "SELECT * FROM user WHERE email = ?";
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
	
		if(result==1){// 중복이 아닐 경우 실행
			try{
				conn = JDBCUtil.getConnection();
				stmt = conn.prepareStatement(doJoinSQL);
				stmt.setString(1, vo.getuName());
				stmt.setString(2, vo.getuEmail());
				stmt.setString(3, vo.getuPw());
				
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
		}else{//중복일 경우
			System.out.println("중복이라 가입 실패");

			joinResult=0;
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
			stmt.setString(1, vo.getuEmail());
			String pw=vo.getuPw();
			ResultSet cnt = stmt.executeQuery();	
			if(cnt.next()){
				if(cnt.getString("pw")!=null&&cnt.getString("pw").equals(pw)){
					//일치하면
					//회원정보를 가져옴
					vo.setuName(cnt.getString("nickname"));
					vo.setUserId(cnt.getInt("userId"));
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
			stmt.setString(1, vo.getuEmail());
			
			
			ResultSet cnt = stmt.executeQuery();	
			if(cnt.next()){
				
					System.out.println("memberDAOImpl - doIdCheck 중복");
					result=-1;
				
			}else{
				System.out.println("memberDAOImpl - doIdCheck 안중복");

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
			stmt.setString(1, vo.getuEmail());
			cnt = stmt.executeQuery();	
			
			if(cnt.next()){

				vo.setuEmail(cnt.getString("email"));
				vo.setuNickname(cnt.getString("nickname"));
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
