package com.mastere1.controller;

import java.util.ArrayList;
import java.util.List;

public class ServletHome extends UtilHttpServlet {

	public void index(){
		
//		this.displayView("index", null);
		
		List<String> model = new ArrayList<>();
		model.add("Alain");
		model.add("Bob");
		model.add("Richard");
		this.displayView(model);
	}
}
