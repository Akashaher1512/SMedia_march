package com.smedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.smedia.service.PostService;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;

}
