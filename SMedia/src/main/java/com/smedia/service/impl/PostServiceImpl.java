package com.smedia.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smedia.dto.PostDto;
import com.smedia.entity.Post;
import com.smedia.exception.ResourceNotFoundException;
import com.smedia.repository.PostRepository;
import com.smedia.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepository postRepository;

	// create post
	
	@Override
	public PostDto createPost(PostDto postDto) {
		
		// convert PostDto to post
		Post post = new Post();
		
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
		
		// save post by using repository layer (o/p => savedPost)
		Post savedPost = postRepository.save(post);
		
		// convert savedPost to PostDto object
		PostDto savedPostDto = new PostDto();
		
		savedPostDto.setId(savedPost.getId());
		savedPostDto.setTitle(savedPost.getTitle());
		savedPostDto.setContent(savedPost.getContent());
		savedPostDto.setDescription(savedPost.getDescription());
		
		return savedPostDto;
	}


	
	@Override
	public List<PostDto> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	
	// get post by id
	
	@Override
	public PostDto getPostById(Long id) {
		// find record in db
		Post post = postRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Post", "Post_Id", id));
		
		// convert post to PostDto
		PostDto postDto = new PostDto();
		postDto.setId(post.getId());
		postDto.setTitle(post.getTitle());
		postDto.setContent(post.getContent());
		postDto.setDescription(post.getDescription());
		
		return postDto;
	}
	
	

	@Override
	public PostDto updatePost(PostDto postDto, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletePost(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
