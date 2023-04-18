package com.smedia.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smedia.dto.PostDto;
import com.smedia.entity.Post;
import com.smedia.exception.ResourceNotFoundException;
import com.smedia.repository.PostRepository;
import com.smedia.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	// create post

	@Override
	public PostDto createPost(PostDto postDto) {

		// convert PostDto to post
		/*
		 * Post post = new Post(); post.setTitle(postDto.getTitle());
		 * post.setDescription(postDto.getDescription());
		 * post.setContent(postDto.getContent());
		 */
		Post post = mapToEntity(postDto);

		// save post by using repository layer (o/p => savedPost)
		Post savedPost = postRepository.save(post);

		// convert savedPost to PostDto object

		/*
		 * PostDto savedPostDto = new PostDto();
		 * 
		 * savedPostDto.setId(savedPost.getId());
		 * savedPostDto.setTitle(savedPost.getTitle());
		 * savedPostDto.setContent(savedPost.getContent());
		 * savedPostDto.setDescription(savedPost.getDescription());
		 */

		PostDto savedPostDto = mapToDto(savedPost);

		return savedPostDto;
	}

	// get all posts

	@Override
	public List<PostDto> getAllPosts() {
		// fetch all posts from db (List<Post>)
		List<Post> postList = postRepository.findAll();
		
		// Convert List<Post> to List<PostDto>
		List<PostDto> postDtoList = postList.stream().map( post -> mapToDto(post)).collect(Collectors.toList());
		
		return postDtoList;
	}

	// get post by id

	@Override
	public PostDto getPostById(Long id) {
		// find record in db
		Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "Post_Id", id));

		// convert post to PostDto
		/*
		 * PostDto postDto = new PostDto(); postDto.setId(post.getId());
		 * postDto.setTitle(post.getTitle()); postDto.setContent(post.getContent());
		 * postDto.setDescription(post.getDescription());
		 */
		PostDto postDto = mapToDto(post);

		return postDto;
	}

	// update post

	@Override
	public PostDto updatePost(PostDto postDto, long id) {
		// fetch record from db for given id (post)
		
		// transfer values from postDto to object that we have fetched from db
		
		// save post object object (savedPosd)
		
		// convert savedPost to PostDtoObject and return it
		
		return null;
	}

	// delete post

	@Override
	public String deletePost(Long id) {
		// fetch record from db for given id (post)
		// delete record from db
		// user String.format() and return msg
		return null;
	}

	// Conversion of Post to PostDto
	private PostDto mapToDto(Post post) {

		PostDto postDto = new PostDto();
		postDto.setId(post.getId());
		postDto.setTitle(post.getTitle());
		postDto.setContent(post.getDescription());
		postDto.setDescription(post.getDescription());

		return postDto;
	}

	// Conversion of PostDto to Post
	private Post mapToEntity(PostDto postDto) {

		Post post = new Post();
		post.setId(postDto.getId());
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());

		return post;
	}

}
