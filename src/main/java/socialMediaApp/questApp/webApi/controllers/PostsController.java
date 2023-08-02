package socialMediaApp.questApp.webApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import socialMediaApp.questApp.business.abstracts.PostService;
import socialMediaApp.questApp.business.requests.PostCreateRequest;
import socialMediaApp.questApp.business.requests.PostUpdateRequest;
import socialMediaApp.questApp.entities.Post;

@RestController
@AllArgsConstructor
@RequestMapping("/api/posts")
public class PostsController {
	
	PostService postService;
	
	@GetMapping()
	public List<Post> getAllPosts(@RequestParam Optional<Integer> userId){
		return postService.getAllPosts(userId);
	}
	
	@GetMapping("/{postId}")
	public Post getOnePost(@PathVariable int postId) {
		return postService.getOnePostById(postId);
	}
	
	@PostMapping
	public Post createOnePost(@RequestBody PostCreateRequest newPostRequest) {
		return postService.createOnePost(newPostRequest);
	}
	
	@PutMapping("/{postId}")
	public Post updateOnePost(@PathVariable int postId, @RequestBody PostUpdateRequest updatePost) {
		return postService.updateOnePostById(postId, updatePost);
	}
	
	@DeleteMapping("/{postId}")
	public void deleteOnePost(@PathVariable int postId) {
		postService.deleteOnePostById(postId);	
	}
	
	

}
