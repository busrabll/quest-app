package socialMediaApp.questApp.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import socialMediaApp.questApp.business.abstracts.CommentService;
import socialMediaApp.questApp.business.abstracts.PostService;
import socialMediaApp.questApp.business.abstracts.UserService;
import socialMediaApp.questApp.business.requests.CommentCreateRequest;
import socialMediaApp.questApp.business.requests.CommentUpdateRequest;
import socialMediaApp.questApp.dataAccess.CommentRepository;
import socialMediaApp.questApp.entities.Comment;
import socialMediaApp.questApp.entities.Post;
import socialMediaApp.questApp.entities.User;

@Service
@AllArgsConstructor
public class CommentManager implements CommentService {
	
	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;

	@Override
	public List<Comment> getAllCommentsWithParam(Optional<Integer> userId, Optional<Integer> postId) {
		if(userId.isPresent() && postId.isPresent()) {
			return commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}else if(userId.isPresent()) {
			return commentRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			return commentRepository.findByPostId(postId.get());
		}else {
			return commentRepository.findAll();
		}
	}

	@Override
	public Comment getOneCommentById(int commentId) {
		return commentRepository.findById(commentId).orElse(null);
	}

	@Override
	public Comment createOneComment(CommentCreateRequest request) {
		User user = userService.getOneUserById(request.getUserId());
		Post post = postService.getOnePostById(request.getPostId());
		if(user != null && post != null) {
			Comment commentToSave = new Comment();
			commentToSave.setId(request.getId());
			commentToSave.setPost(post);
			commentToSave.setUser(user);
			commentToSave.setText(request.getText());
			return commentRepository.save(commentToSave);
		}else
			return null;
	}

	@Override
	public Comment updateOneCommentById(int commentId, CommentUpdateRequest request) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		if(comment.isPresent()) {
			Comment commentToUpdate = comment.get();
			commentToUpdate.setText(request.getText());
			return commentRepository.save(commentToUpdate);
		}else
			return null;
	}

	@Override
	public void deleteOneCommentById(int commentId) {
		commentRepository.deleteById(commentId);
	}

}
