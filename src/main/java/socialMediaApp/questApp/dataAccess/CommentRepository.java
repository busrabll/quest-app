package socialMediaApp.questApp.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import socialMediaApp.questApp.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
