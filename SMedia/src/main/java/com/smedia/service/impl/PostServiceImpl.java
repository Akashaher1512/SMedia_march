package com.smedia.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.smedia.dto.ApiResponse;
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
	public ApiResponse<PostDto> getAllPosts(int pageNumber , int pageSize , String sortBy , String sortDir) {
		// sorting
		
		Sort sort = null;
		
		if (sortDir.equalsIgnoreCase("Desc")) {
			sort = sort.by(sortBy).descending();
		}else {
			sort = sort.by(sortBy).ascending();
		}
	
		// crate object of pageable
		Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
		
		// fetch Page from db 
		Page<Post> page = postRepository.findAll(pageable);
		
		// assign values to ApiResponse<T>
		ApiResponse<PostDto> response = new ApiResponse<PostDto>();
		
		response.setContent(page.getContent());
		response.setFirst(page.isFirst());
		response.setLast(page.isLast());
		response.setPageNumber(page.getNumber()+1);
		response.setPageSize(page.getSize());
		response.setTotleElements(page.getTotalElements());
		response.setTotlePages(page.getTotalPages());
		
		
		return response;
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
		Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "Post_Id", id));
		// transfer values from postDto to object that we have fetched from db
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		// save post object object (savedPosd)
		Post updatedPost = postRepository.save(post);
		
		// convert savedPost to PostDtoObject and return it
		PostDto updatedPostDto = mapToDto(updatedPost);
		
		return updatedPostDto;
	}

	// delete post

	@Override
	public String deletePost(Long id) {
		// fetch record from db for given id (post)
		Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "Post_Id", id));
		// delete record from db
		postRepository.delete(post);
		// user String.format() and return msg
		return String.format("Post with Post_Id : %s deleted scessfully..!!", id);
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
