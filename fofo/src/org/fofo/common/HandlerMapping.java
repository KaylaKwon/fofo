package org.fofo.common;

import java.util.HashMap;

import org.fofo.board.controller.AddBoardController;
import org.fofo.board.controller.GetBoardController;
import org.fofo.board.controller.GetBoardListController;
import org.fofo.board.controller.ModifyBoardController;
import org.fofo.board.controller.ModifyViewBoardController;
import org.fofo.project.controller.AddProjectController;
import org.fofo.project.controller.ProjectController;


public class HandlerMapping {

	HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		init();
	}
	
	void init(){
//		mappings.put("/hello.do", new HelloController());
		mappings.put("/login.do", new GetBoardListController());
		mappings.put("/freeboard.do", new GetBoardListController());
		mappings.put("/getfreeboard.do", new GetBoardController());
		mappings.put("/addfreeboard.do", new AddBoardController());
		mappings.put("/modifyfreeboard.do", new ModifyBoardController());
		mappings.put("/modifyviewfreeboard.do", new ModifyViewBoardController());
		mappings.put("/addProjectList.do", new AddProjectController());
		mappings.put("/project.do", new ProjectController());
		
	}
	
	public Controller getController(String path){
		return mappings.get(path);
	}

}
