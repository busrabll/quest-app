package socialMediaApp.questApp.business.abstracts;

import java.util.List;
import java.util.Optional;

import socialMediaApp.questApp.business.requests.PostCreateRequest;
import socialMediaApp.questApp.business.requests.PostUpdateRequest;
import socialMediaApp.questApp.business.responses.PostResponse;
import socialMediaApp.questApp.entities.Post;

public interface PostService {

	List<PostResponse> getAllPosts(Optional<Integer> userId);
	Post getOnePostById(int postId);
	Post createOnePost(PostCreateRequest newPostRequest);
	Post updateOnePostById(int postId, PostUpdateRequest updatePost);
	void deleteOnePostById(int postId);
}
