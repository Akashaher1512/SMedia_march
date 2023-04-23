package com.smedia.service;

import com.smedia.dto.ApiResponse;
import com.smedia.dto.PostDto;

public interface PostService {

	// create post
	PostDto createPost(PostDto postDto);
	
	// get all posts
	ApiResponse<PostDto> getAllPosts(int pageNumber , int pageSize , String sortBy , String sortDir);
	
	// get post by id
	PostDto getPostById(Long id);
	
	// update post
	PostDto updatePost(PostDto postDto , long id);
	
	// delete post
	String deletePost(Long id);
	
	// search posts by name
	
}
