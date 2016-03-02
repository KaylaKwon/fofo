package org.fofo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.fofo.board.vo.FreePost;
import org.fofo.common.JDBCUtil;

public class FreeBoardDAO {

	private static String addBoardSQL = "insert into board(title, writer, content) values(?, ?, ?)";
	private static String listBoardSQL = "select * from freepost order by fpostdate desc";
	private static String getBoardSQL = "select * from board where seq = ?";
	private static String countBoardSQL = "update board set cnt  = cnt + 1 where seq = ?";
	private static String updateBoardSQL = "update board set title = ?, content = ? where seq = ?";
	
	public void doUpdateBoard(FreePost freepost){
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
	//			System.out.println("updateBoard ?óê?ü¨ : " + e);
	//		}finally{
	//			JDBCUtil.close(stmt, conn);
	//		}
		}
		
	//	
	public void doGetBoard(FreePost freepost){
	//	
	//	Connection conn = null;
	//	PreparedStatement stmt = null;
	//	ResultSet rst = null;
	//	try{
	//		conn = JDBCUtil.getConnection();
	//		stmt = conn.prepareStatement(countBoardSQL);
	//		stmt.setInt(1, board.getSeq());
	//		stmt.executeUpdate();
	//		stmt.clearParameters();
	//		
	//		stmt = conn.prepareStatement(getBoardSQL);
	//		stmt.setInt(1, board.getSeq());
	//		rst = stmt.executeQuery();
	//		if(rst.next()){
	//			board.setSeq(rst.getInt("seq"));
	//			board.setTitle(rst.getString("title"));
	//			board.setWriter(rst.getString("writer"));
	//			board.setContent(rst.getString("content"));
	//			board.setRegdate(rst.getString("regdate"));
	//			board.setCnt(rst.getInt("cnt"));
	//		}
	//	}catch(SQLException e){
	//		System.out.println("list error : " + e);
	//	}finally{
	//		JDBCUtil.close(rst, stmt, conn);
	//	}
	}
		
	public ArrayList<FreePost> doListBoard(){
		ArrayList<FreePost> list = new ArrayList<FreePost>();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rst = null;
		FreePost freepost = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(listBoardSQL);
			System.out.println("gg");
			rst = stmt.executeQuery();
			while(rst.next()){
				freepost = new FreePost();
				freepost.setfPostId(rst.getInt("fPostId"));
				freepost.setBoardId(rst.getInt("BoardId"));
				freepost.setUserId(rst.getInt("UserId"));
				freepost.setfHitNum(rst.getInt("fHitNum"));
				freepost.setfRecommendNum(rst.getInt("fRecommendNum"));
				freepost.setfCommentNum(rst.getInt("fCommentNum"));
				freepost.setfBookmarkNum(rst.getInt("fBookmarkNum"));
				freepost.setfPostDate(rst.getString("fPostDate"));
				freepost.setfPostTitle(rst.getString("fPostTitle"));
				freepost.setfPostContent(rst.getString("fPostContent"));
				freepost.setfTags(rst.getString("fTags"));
				list.add(freepost);
			}
		}catch(SQLException e){
			System.out.println("list error : " + e);
		}finally{
			JDBCUtil.close(rst, stmt, conn);
		}
		System.out.println(list);
		return list;
	}
	
	public void doAddBoard(FreePost board){
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
	//		System.out.println("addBoard ?óê?ü¨ : " + e);
	//	}finally{
	//		JDBCUtil.close(stmt, conn);
	//	}
	}
	
	public FreeBoardDAO() {
		// TODO Auto-generated constructor stub
	}
}
