package socialMediaApp.questApp.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import socialMediaApp.questApp.business.abstracts.LikeService;
import socialMediaApp.questApp.business.abstracts.PostService;
import socialMediaApp.questApp.business.abstracts.UserService;
import socialMediaApp.questApp.business.requests.LikeCreateRequest;
import socialMediaApp.questApp.business.responses.LikeResponse;
import socialMediaApp.questApp.dataAccess.LikeRepository;
import socialMediaApp.questApp.entities.Like;
import socialMediaApp.questApp.entities.Post;
import socialMediaApp.questApp.entities.User;

@Service
@AllArgsConstructor
public class LikeManager implements LikeService {
	
	private LikeRepository likeRepository;
	UserService userService;
	PostService postService;

	@Override
	public List<LikeResponse> getAllLikesWithParam(Optional<Integer> userId, Optional<Integer> postId) {
		List<Like> list;
		if(userId.isPresent() && postId.isPresent()) {
			list = likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}else if(userId.isPresent()) {
			list = likeRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			list = likeRepository.findByPostId(postId.get());
		}else
			list = likeRepository.findAll();
		return list.stream().map(like -> new LikeResponse()).collect(Collectors.toList());
	}

	@Override
	public Like getOneLikeById(int likeId) {
		return likeRepository.findById(likeId).orElse(null);
	}

	@Override
	public Like createOneLike(LikeCreateRequest request) {
		User user = userService.getOneUserById(request.getUserId());
		Post post = postService.getOnePostById(request.getPostId());
		if(user != null && post != null) {
			Like likeToSave = new Like();
			likeToSave.setId(request.getId());
			likeToSave.setPost(post);
			likeToSave.setUser(user);
			return likeRepository.save(likeToSave);
		}else
			return null;
	}

	@Override
	public void deleteOneLikeById(int likeId) {
		likeRepository.deleteById(likeId);	
	}

}
