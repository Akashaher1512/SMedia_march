package com.smedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smedia.dto.PostDto;
import com.smedia.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	
	// create post controller
	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
		PostDto createPost = postService.createPost(postDto);
		
		return new ResponseEntity<PostDto>( createPost , HttpStatus.CREATED );
	}
	
	// get post by id controller
	
	@GetMapping("/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable(name = "postId") Long id){
		
		PostDto post = postService.getPostById(id);
		
		return new ResponseEntity<PostDto>(post , HttpStatus.OK);
	}
	
	
	// get all posts
	@GetMapping
	public ResponseEntity<List<PostDto>> getAllPosts(){
		List<PostDto> allPosts = postService.getAllPosts();
		
		return new ResponseEntity<>( allPosts , HttpStatus.OK );
	}
	
	// update post
	
	// delete post
	
	
}






