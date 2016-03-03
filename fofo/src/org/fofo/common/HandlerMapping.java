package org.fofo.common;

import java.util.HashMap;

import org.fofo.board.controller.GetBoardController;
import org.fofo.board.controller.GetBoardListController;
import org.fofo.project.controller.AddProjectController;


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
<<<<<<< HEAD
		mappings.put("/addProjectList.do", new AddProjectController());
		mappings.put("/project.do", new ProjectController());
=======
		mappings.put("/getfreeboard.do", new GetBoardController());
		mappings.put("/addProjectList.do", new AddProjectController());
		mappings.put("/project.do", new AddProjectController());
>>>>>>> ffe1df134bc822e4580f2aae56901e9b0291f1a8
		
	}
	
	public Controller getController(String path){
		return mappings.get(path);
	}

}
