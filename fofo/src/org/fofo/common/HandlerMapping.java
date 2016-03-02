package org.fofo.common;

import java.util.HashMap;

import org.fofo.board.controller.GetBoardListController;
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
<<<<<<< HEAD
		mappings.put("/login.do", new GetBoardListController());
		mappings.put("/freeboard.do", new GetBoardListController());
=======
		mappings.put("/addProjectList.do", new AddProjectController());
		mappings.put("/project.do", new ProjectController());
>>>>>>> f4ea3700560b647070f448546cef01825582046d
		
	}
	
	public Controller getController(String path){
		return mappings.get(path);
	}

}
