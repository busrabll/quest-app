package socialMediaApp.questApp.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import socialMediaApp.questApp.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	List<Comment> findByUserIdAndPostId(int userId, int postId);
	
	List<Comment> findByUserId(int userId);
	
	List<Comment> findByPostId(int postId);

}
