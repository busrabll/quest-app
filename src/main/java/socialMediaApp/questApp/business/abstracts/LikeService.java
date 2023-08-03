package socialMediaApp.questApp.business.abstracts;

import java.util.List;
import java.util.Optional;

import socialMediaApp.questApp.business.requests.LikeCreateRequest;
import socialMediaApp.questApp.business.responses.LikeResponse;
import socialMediaApp.questApp.entities.Like;

public interface LikeService {
	
	List<LikeResponse> getAllLikesWithParam(Optional<Integer> userId, Optional<Integer> postId);
	Like getOneLikeById(int likeId);
	Like createOneLike(LikeCreateRequest request);
	void deleteOneLikeById(int likeId);
}
