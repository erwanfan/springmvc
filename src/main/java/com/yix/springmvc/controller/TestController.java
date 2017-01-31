package com.yix.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yix.springmvc.object.Admin;
import com.yix.springmvc.object.User;
import com.yix.springmvc.object.UserList;
import com.yix.springmvc.object.UserMap;
import com.yix.springmvc.object.UserSet;

@Controller
public class TestController {
	
	//http://localhost:8080/springmvc/baseType.do?age=10
	@RequestMapping(value="baseType.do")
	@ResponseBody
	public String baseType(@RequestParam int age) {
		System.out.println("TestController did baseType().. age: " + age);
		return "age: " + age;
	}
	
	//http://localhost:8080/springmvc/array.do?name=td&name=nemo
	@RequestMapping(value="array.do")
	@ResponseBody
	public String array(@RequestParam String[] name) {
		StringBuilder sb = new StringBuilder();
		for (String s : name) {
			sb.append(s).append(" ");
		}
		System.out.println("TestController did array().. name: " + sb);
		return "name: " + sb;
	}
	
	//http://localhost:8080/springmvc/object.do?name=td&name=nemo&age=10
	//http://localhost:8080/springmvc/object.do?name=td&name=nemo&age=10&contactInfo.phone=10086&contactInfo.address=shanghaiminhang
	@RequestMapping(value="object.do")
	@ResponseBody
	public String object(User user) {
		System.out.println("TestController did object().. user: " + user);
		return "user: " + user;
	}
	
	//http://localhost:8080/springmvc/multiObject.do?name=td&name=nemo&age=10
	//user: User [name=td,nemo, age=10, contactInfo=null] admin: Admin [name=td,nemo, age=10]
	@RequestMapping(value="multiObject.do")
	@ResponseBody
	public String multiObject(User user, Admin admin) {
		System.out.println("TestController did multiObject().. user: " + user + " admin: " + admin);
		return "user: " + user + " admin: " + admin;
	}
	
	//http://localhost:8080/springmvc/multiObject.do?user.name=td&admin.name=nemo&age=10
	//user: User [name=td, age=10, contactInfo=null] admin: Admin [name=nemo, age=10]
	@InitBinder("user")
	public void initUser(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("user.");
	}
	
	@InitBinder("admin")
	public void initAdmin(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("admin.");
	}
	
	//http://localhost:8080/springmvc/list.do?users[0].name=TD&users[1].name=Nemo&users[1].age=7
	//UserList [users=[User [name=TD, age=null, contactInfo=null], User [name=Nemo, age=7, contactInfo=null]]]
	@RequestMapping(value="list.do")
	@ResponseBody
	public String list(UserList userList) {
		System.out.println("TestController did list().. userList: " + userList);
		return "userList: " + userList ;
	}
	
	//Set需要先初始化
	//http://localhost:8080/springmvc/set.do?users[0].name=TD&users[1].name=TD
	@RequestMapping(value="set.do")
	@ResponseBody
	public String set(UserSet userSet) {
		System.out.println("TestController did set().. userSet: " + userSet);
		return "userSet: " + userSet ;
	}
	
	//http://localhost:8080/springmvc/map.do?users[%27X%27].name=TD&users[%27Y%27].name=Nemo
	//UserMap [users={X=User [name=TD, age=null, contactInfo=null], Y=User [name=Nemo, age=null, contactInfo=null]}]
	@RequestMapping(value="map.do")
	@ResponseBody
	public String map(UserMap userMap) {
		System.out.println("TestController did map().. userMap: " + userMap);
		return "userMap: " + userMap;
	}
	
	@RequestMapping(value="json.do")
	@ResponseBody
	public String json(@RequestBody User user) {
		System.out.println("TestController did json().. user: " + user);
		return "user: " + user;
	}
	
	@RequestMapping(value="xml.do")
	@ResponseBody
	public String xml(@RequestBody Admin admin) {
		System.out.println("TestController did xml().. admin: " + admin);
		return "admin: " + admin;
	}
	
	@RequestMapping(value="converter.do")
	@ResponseBody
	public String converter(Boolean bool) {
		return bool.toString();
	}
	
	@RequestMapping(value="date1.do")
	@ResponseBody
	public String date1(Date date1) {
		return date1.toString();
	}
	
//	@InitBinder("date1")
//	public void initDate1(WebDataBinder binder) {
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
//	}
	
	@RequestMapping(value="date2.do")
	@ResponseBody
	public String date2(Date date2) {
		return date2.toString();
	}
	
	@RequestMapping(value="/book/{bookId}")
	@ResponseBody
	public String book(HttpServletRequest request, @PathVariable("bookId") String bookId) {
		String contentType = request.getContentType();
		return contentType + " " + bookId;
//		if("".equals(contentType) || null == contentType){
//			return "book.default";
//		}else if("txt".equals(contentType)){
//			return "book.txt";
//		}else if("html".equals(contentType)){
//			return "book.html";
//		}else{
//			return "book.default";
//		}
	}
}
