package socialMediaApp.questApp.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import socialMediaApp.questApp.entities.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {

}
