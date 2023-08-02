package socialMediaApp.questApp.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import socialMediaApp.questApp.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> findByUserId(int userId);

}
