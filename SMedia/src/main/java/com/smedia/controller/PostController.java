package com.smedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smedia.dto.ApiResponse;
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
	public ResponseEntity<ApiResponse<PostDto>> getAllPosts(
			@RequestParam(name = "pageNumber" , defaultValue = "1" , required = false) int pageNumber , 
			@RequestParam(name = "pageSize" , defaultValue = "5" , required = false) int pageSize , 
			@RequestParam(name = "sortBy" , defaultValue = "id" , required = false) String sortBy , 
			@RequestParam(name = "sortDir" , defaultValue = "Asc" , required = false) String sortDir
			){
		
		ApiResponse<PostDto> response = postService.getAllPosts(pageNumber-1,pageSize,sortBy,sortDir);

		return new ResponseEntity<>( response , HttpStatus.OK );
	}
	
	// update post
	@PutMapping("/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto ,@PathVariable(name ="postId") long id){
		PostDto updatePost = postService.updatePost(postDto, id);
		
		return new ResponseEntity<>(updatePost , HttpStatus.OK);
	}
	
	// delete post
	@DeleteMapping("/{postId}")
	public ResponseEntity<String> deletePost(@PathVariable(name ="postId") long id){
		String msg = postService.deletePost(id);
		
		return new ResponseEntity<>(msg , HttpStatus.OK);
	}
	
	
}






