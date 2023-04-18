package com.smedia.service;

import java.util.List;

import com.smedia.dto.PostDto;

public interface PostService {

	// create post
	PostDto createPost(PostDto postDto);
	
	// get all posts
	List<PostDto> getAllPosts();
	
	// get post by id
	PostDto getPostById(Long id);
	
	// update post
	PostDto updatePost(PostDto postDto , long id);
	
	// delete post
	String deletePost(Long id);
	
	// search posts by name
	
}
