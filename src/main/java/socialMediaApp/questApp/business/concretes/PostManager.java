package socialMediaApp.questApp.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import socialMediaApp.questApp.business.abstracts.PostService;
import socialMediaApp.questApp.business.abstracts.UserService;
import socialMediaApp.questApp.business.requests.PostCreateRequest;
import socialMediaApp.questApp.business.requests.PostUpdateRequest;
import socialMediaApp.questApp.dataAccess.PostRepository;
import socialMediaApp.questApp.entities.Post;
import socialMediaApp.questApp.entities.User;

@Service
@AllArgsConstructor
public class PostManager implements PostService {
	
	private PostRepository postRepository;
	private UserService userService;

	@Override
	public List<Post> getAllPosts(Optional<Integer> userId) {
		if(userId.isPresent())
			return postRepository.findByUserId(userId.get());
		return postRepository.findAll();
	}

	@Override
	public Post getOnePostById(int postId) {
		return postRepository.findById(postId).orElse(null);
	}

	@Override
	public Post createOnePost(PostCreateRequest newPostRequest) {
		User user = userService.getOneUserById(newPostRequest.getUserId());
		if(user == null)
			return null;
		Post toSave = new Post();
		toSave.setId(newPostRequest.getId());
		toSave.setText(newPostRequest.getText());
		toSave.setTitle(newPostRequest.getTitle());
		toSave.setUser(user);
		
		return postRepository.save(toSave);
	}

	@Override
	public Post updateOnePostById(int postId, PostUpdateRequest updatePost) {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	@Override
	public void deleteOnePostById(int postId) {
		postRepository.deleteById(postId);
	}

}
