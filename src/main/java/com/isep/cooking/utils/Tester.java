package com.isep.cooking.utils;

import com.isep.cooking.jsonEntities.JsonRecipeRequest;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;


public class Tester {

	public static void main(String[] args) {
		
		List<String> ids = new ArrayList<>();
		ids.add("myFirstId");
		
		JsonRecipeRequest req = new JsonRecipeRequest(ids);
		
		JSONObject obj = new JSONObject(req);
		
		System.out.println(obj.toString());
		
	}
	
}
