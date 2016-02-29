package org.fofo.common;

import java.util.HashMap;


public class HandlerMapping {

	HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		init();
	}
	
	void init(){
//		mappings.put("/hello.do", new HelloController());
		
	}
	
	public Controller getController(String path){
		return mappings.get(path);
	}

}
