package org.fofo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fofo.board.vo.QAPost;
import org.fofo.common.JDBCUtil;

public class QABoardDAO {
	
	private static String addBoardSQL = "insert into board(title, writer, content) values(?, ?, ?)";
	private static String listBoardSQL = "select * from qapost order by fpostdate desc";
	private static String getBoardSQL = "select * from qapost where setfPostId = ?";
	private static String countBoardSQL = "update qapost set fhitNum  = fhitNum + 1 where setfPostId = ?";
	private static String updateBoardSQL = "update qapost set title = ?, content = ? where seq = ?";
	
	public void doUpdateBoard(QAPost qapost){
//		
	//		Connection conn = null;
	//		PreparedStatement stmt = null;
	//		try{
	//			conn = JDBCUtil.getConnection();
	//			stmt = conn.prepareStatement(updateBoardSQL);
	//			stmt.setString(1, freepost.getTitle());
	//			stmt.setString(2, freepost.getContent());
	//			stmt.setInt(3, freepost.getSeq());
	//			int cnt = stmt.executeUpdate();
	//			if(cnt == 1){
	//				System.out.println("updateBoard success");
	//			}else{
	//				System.out.println("updateBoard fail");
	//			}
	//		}catch(SQLException e){
	//			System.out.println("updateBoard ?��?�� : " + e);
	//		}finally{
	//			JDBCUtil.close(stmt, conn);
	//		}
	}
	

	public void doGetBoard(QAPost qapost){
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(countBoardSQL);
			stmt.setInt(1, qapost.getqaPostId());
			stmt.executeUpdate();
			stmt.clearParameters();
			
			stmt = conn.prepareStatement(getBoardSQL);
			stmt.setInt(1, qapost.getqaPostId());
			rst = stmt.executeQuery();
			if(rst.next()){
				qapost.setqaPostId(rst.getInt("qaPostId"));
				qapost.setBoardId(rst.getInt("BoardId"));
				qapost.setUserId(rst.getInt("UserId"));
				qapost.setqaHitNum(rst.getInt("qaHitNum"));
				qapost.setqaRecommendNum(rst.getInt("qaRecommendNum"));
				qapost.setqaCommentNum(rst.getInt("qaCommentNum"));
				qapost.setqaBookmarkNum(rst.getInt("qaBookmarkNum"));
				qapost.setqaPostDate(rst.getString("qaPostDate"));
				qapost.setqaPostTitle(rst.getString("qaPostTitle"));
				qapost.setqaPostContent(rst.getString("qaPostContent"));
				qapost.setqaTags(rst.getString("qaTags"));
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
	}
		
	public ArrayList<QAPost> doListBoard(){
		ArrayList<QAPost> list = new ArrayList<QAPost>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		QAPost qapost = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(listBoardSQL);
			System.out.println("gg");
			rst = stmt.executeQuery();
			while(rst.next()){
				qapost = new QAPost();
				qapost.setqaPostId(rst.getInt("qaPostId"));
				qapost.setBoardId(rst.getInt("BoardId"));
				qapost.setUserId(rst.getInt("UserId"));
				qapost.setqaHitNum(rst.getInt("qaHitNum"));
				qapost.setqaRecommendNum(rst.getInt("qaRecommendNum"));
				qapost.setqaCommentNum(rst.getInt("qaCommentNum"));
				qapost.setqaBookmarkNum(rst.getInt("qaBookmarkNum"));
				qapost.setqaPostDate(rst.getString("qaPostDate"));
				qapost.setqaPostTitle(rst.getString("qaPostTitle"));
				qapost.setqaPostContent(rst.getString("qaPostContent"));
				qapost.setqaTags(rst.getString("qaTags"));
				list.add(qapost);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
		System.out.println(list);
		return list;
	}
	
	public void doAddBoard(QAPost board){
	//	
	//	Connection conn = null;
	//	PreparedStatement stmt = null;
	//	try{
	//		conn = JDBCUtil.getConnection();
	//		stmt = conn.prepareStatement(addBoardSQL);
	//		stmt.setString(1, board.getTitle());
	//		stmt.setString(2, board.getWriter());
	//		stmt.setString(3, board.getContent());
	//		int cnt = stmt.executeUpdate();
	//		if(cnt == 1){
	//			System.out.println("addBoard success");
	//		}else{
	//			System.out.println("addBoard fail");
	//		}
	//	}catch(SQLException e){
	//		System.out.println("addBoard ?��?�� : " + e);
	//	}finally{
	//		JDBCUtil.close(stmt, conn);
	//	}
	}
	
	public QABoardDAO() {
		// TODO Auto-generated constructor stub
	}

}
