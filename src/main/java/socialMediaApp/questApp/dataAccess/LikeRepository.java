package socialMediaApp.questApp.dataAccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import socialMediaApp.questApp.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {
	
	List<Like> findByUserIdAndPostId(int userId, int postId);
	
	List<Like> findByUserId(int userId);
	
	List<Like> findByPostId(int postId);

}
