package org.fofo.common;

import java.util.HashMap;

import org.fofo.freeboard.controller.AddBoardController;
import org.fofo.freeboard.controller.GetBoardController;
import org.fofo.freeboard.controller.GetBoardListController;
import org.fofo.freeboard.controller.ModifyBoardController;
import org.fofo.freeboard.controller.ModifyViewBoardController;
import org.fofo.freeboard.controller.RemoveBoardController;
import org.fofo.freecomment.controller.AddCommentController;
import org.fofo.freecomment.controller.ModifyCommentController;
import org.fofo.freecomment.controller.ModifyViewCommentController;
import org.fofo.freecomment.controller.RemoveCommentController;
import org.fofo.member.controller.DoIdCheckController;
import org.fofo.member.controller.DoJoinController;
import org.fofo.member.controller.DoLoginController;
import org.fofo.member.controller.DoLogoutController;
import org.fofo.project.controller.AddProjectController;
import org.fofo.project.controller.GetProjectEditorController;
import org.fofo.qaboard.controller.AddQABoardController;
import org.fofo.qaboard.controller.GetQABoardListController;
import org.fofo.qaboard.controller.GetQABoardController;

public class HandlerMapping {

	HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		init();
	}
	
	void init(){
//		mappings.put("/hello.do", new HelloController());
		
		/* Board */
		mappings.put("/freeboard.do", new GetBoardListController());
//		mappings.put("/addProjectList.do", new AddProjectController());
//		mappings.put("/getProjectEditor.do", new GetProjectEditorController());
		mappings.put("/getfreeboard.do", new GetBoardController());
		mappings.put("/addfreeboard.do", new AddBoardController());
		mappings.put("/modifyfreeboard.do", new ModifyBoardController());
		mappings.put("/removefreeboard.do", new RemoveBoardController());
		mappings.put("/modifyviewfreeboard.do", new ModifyViewBoardController());
		mappings.put("/qaboard.do", new GetQABoardListController());
		mappings.put("/addqaboard.do", new AddQABoardController());
		mappings.put("/getqaboard.do", new GetQABoardController());
		
		mappings.put("/addfreecomment.do", new AddCommentController());
		mappings.put("/removefreecomment.do", new RemoveCommentController());
		mappings.put("/modifyviewfreecomment.do", new ModifyViewCommentController());
		mappings.put("/modifyfreecomment.do", new ModifyCommentController());
		mappings.put("/addProjectList.do", new AddProjectController());
//		mappings.put("/addProjectList.do", new AddProjectController());
		
		
		
		/* Project */
		mappings.put("/addProject.do", new AddProjectController());
		mappings.put("/project.do", new GetProjectEditorController());
		
		
		
		/* Member */
		mappings.put("/doJoin.do", new DoJoinController());
		mappings.put("/doLogout.do", new DoLogoutController());
		mappings.put("/doLogin.do", new DoLoginController());
		mappings.put("/doLogout.do", new DoLogoutController());
		mappings.put("/idCheck.do", new DoIdCheckController());
//		mappings.put("/project.do", new ProjectController());
//		mappings.put("/addProjectList.do", new AddProjectController());
		
	}
	
	public Controller getController(String path){
		return mappings.get(path);
	}

}
