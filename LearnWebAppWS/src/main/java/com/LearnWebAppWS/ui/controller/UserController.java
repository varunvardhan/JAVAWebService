package com.LearnWebAppWS.ui.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LearnWebAppWS.ui.modal.RestUser;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {
	
	//@GetMapping
	//public String getUser() {
	//	return "get user was called";
	//}
	//@GetMapping
	//public String getUserss(@RequestParam(value="page") int page,@RequestParam(value="limit") int limit) {
	//	return "get user was called using page =" + page + "and limit ="+limit;
	//}
	@GetMapping
	public String getUser(@RequestParam(value="page", defaultValue="1") int page,@RequestParam(value="limit", defaultValue="10") int limit) {
		return "get user was called with default page "+page+" and limit default =" + limit ;
	}

	@GetMapping(path="/{userid}")
	public String getUsers(@PathVariable String userid) {
		return "get user was called : " + userid;
	}
	@GetMapping(path="/{userid}/{jsonobject}")
	public RestUser getUserssss(@PathVariable int userid,@PathVariable String jsonobject) {
		RestUser returnvalue = new RestUser();
		returnvalue.setId(userid);
		returnvalue.setName(jsonobject);
		
		return returnvalue;
	}
	@GetMapping(path="/{userid}/{jsonobject}/{xxml}", produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public RestUser getUserss(@PathVariable int userid,@PathVariable String jsonobject,@PathVariable String xxml) {
		RestUser returnvalue = new RestUser();
		returnvalue.setId(userid);
		returnvalue.setName(jsonobject);
		
		return returnvalue;
	}
	@PostMapping
	public String createUser() {
		return "create user was called";
	}
	@PutMapping
	public String updateUser() {
		return "create user was called";
	}
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}

}
