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

import socialMediaApp.questApp.business.abstracts.CommentService;
import socialMediaApp.questApp.business.requests.CommentCreateRequest;
import socialMediaApp.questApp.business.requests.CommentUpdateRequest;
import socialMediaApp.questApp.entities.Comment;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
	
	private CommentService commentService;
	
	@GetMapping
	public List<Comment> getAllComments(@RequestParam Optional<Integer> userId,
			@RequestParam Optional<Integer> postId){
		return commentService.getAllCommentsWithParam(userId, postId);
		
	}
	
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable int commentId) {
		return commentService.getOneCommentById(commentId);
	}
	
	@PostMapping
	public Comment createOneComment(@RequestBody CommentCreateRequest request) {
		return commentService.createOneComment(request);
	}
	
	@PutMapping("/{commentId}")
	public Comment updateOneComment(@PathVariable int commentId, @RequestBody CommentUpdateRequest request) {
		return commentService.updateOneCommentById(commentId, request);
	}
	
	@DeleteMapping("/{commentId}")
	public void  deleteOneComment(@PathVariable int commentId) {
		commentService.deleteOneCommentById(commentId);
	}
	
	

}
