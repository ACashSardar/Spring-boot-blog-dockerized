package com.akash.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.akash.blog.service.CategoryService;
import com.akash.blog.service.PostService;
@RestController
public class HomeController {
	
	@Autowired
	PostService postService;
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("redirect:/page/0");
	}	
    
    @GetMapping(value ={"/*","/posts/**","/login/**","/register/**","/adminlogin/**"})
    public ModelAndView handleInvalidAPIReq(){
    	return new ModelAndView("Error404","message","Oops!! RESOURCE NOT AVAILABE");
    }
}
