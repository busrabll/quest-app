package socialMediaApp.questApp.business.abstracts;

import java.util.List;
import java.util.Optional;

import socialMediaApp.questApp.business.requests.CommentCreateRequest;
import socialMediaApp.questApp.business.requests.CommentUpdateRequest;
import socialMediaApp.questApp.entities.Comment;

public interface CommentService {
	
	List<Comment> getAllCommentsWithParam(Optional<Integer> userId, Optional<Integer> postId );
	Comment getOneCommentById(int commentId);
	Comment createOneComment(CommentCreateRequest request);
	Comment updateOneCommentById(int commentId, CommentUpdateRequest request);
	void deleteOneCommentById(int commentId);

}
