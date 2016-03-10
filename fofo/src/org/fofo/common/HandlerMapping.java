package org.fofo.common;

import java.util.HashMap;

<<<<<<< HEAD
import org.fofo.freeboard.controller.AddBoardController;
import org.fofo.freeboard.controller.GetBoardController;
import org.fofo.freeboard.controller.GetBoardListController;
import org.fofo.freeboard.controller.ModifyBoardController;
import org.fofo.freeboard.controller.ModifyViewBoardController;
import org.fofo.freeboard.controller.RemoveBoardController;
import org.fofo.freecomment.controller.AddCommentController;
import org.fofo.freecomment.controller.RemoveCommentController;
=======
import org.fofo.board.controller.AddBoardController;
import org.fofo.board.controller.GetBoardController;
import org.fofo.board.controller.GetBoardListController;
import org.fofo.board.controller.ModifyBoardController;
import org.fofo.board.controller.ModifyViewBoardController;
import org.fofo.board.controller.RemoveBoardController;
import org.fofo.member.controller.DoJoinController;
import org.fofo.member.controller.DoLoginController;
import org.fofo.member.controller.DoLogoutController;
>>>>>>> 410edb6a4e49be4cac87d63561d5515b269e44fd
import org.fofo.project.controller.AddProjectController;


public class HandlerMapping {

	HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		init();
	}
	
	void init(){
//		mappings.put("/hello.do", new HelloController());
		mappings.put("/freeboard.do", new GetBoardListController());
//		mappings.put("/addProjectList.do", new AddProjectController());
//		mappings.put("/getProjectEditor.do", new GetProjectEditorController());
<<<<<<< HEAD
=======
		//위에 에러나서 주석처리함
>>>>>>> 410edb6a4e49be4cac87d63561d5515b269e44fd
		mappings.put("/getfreeboard.do", new GetBoardController());
		mappings.put("/addfreeboard.do", new AddBoardController());
		mappings.put("/modifyfreeboard.do", new ModifyBoardController());
		mappings.put("/removefreeboard.do", new RemoveBoardController());
		mappings.put("/modifyviewfreeboard.do", new ModifyViewBoardController());
<<<<<<< HEAD
		mappings.put("/addfreecomment.do", new AddCommentController());
		mappings.put("/removefreecomment.do", new RemoveCommentController());
		mappings.put("/addProjectList.do", new AddProjectController());
=======
		
//		mappings.put("/addProjectList.do", new AddProjectController());
		mappings.put("/project.do", new GetProjectEditorController());
		
		mappings.put("/doJoin.do", new DoJoinController());
		mappings.put("/doLogout.do", new DoLogoutController());
		mappings.put("/doLogin.do", new DoLoginController());

>>>>>>> 410edb6a4e49be4cac87d63561d5515b269e44fd
//		mappings.put("/project.do", new ProjectController());
//		mappings.put("/addProjectList.do", new AddProjectController());
		
	}
	
	public Controller getController(String path){
		return mappings.get(path);
	}

}
