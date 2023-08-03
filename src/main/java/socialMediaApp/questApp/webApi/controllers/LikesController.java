package socialMediaApp.questApp.webApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import socialMediaApp.questApp.business.abstracts.LikeService;
import socialMediaApp.questApp.business.requests.LikeCreateRequest;
import socialMediaApp.questApp.business.responses.LikeResponse;
import socialMediaApp.questApp.entities.Like;

@RestController
@RequestMapping("/api/likes")
public class LikesController {
	
	private LikeService likeService;
	
	@GetMapping
	public List<LikeResponse> getAllLikes(@RequestParam Optional<Integer> userId,
			@RequestParam Optional<Integer> postId){
		return likeService.getAllLikesWithParam(userId, postId);
	}
	
	@PostMapping
	public Like createOneLike(@RequestBody LikeCreateRequest request) {
		return likeService.createOneLike(request);
	}
	
	@GetMapping("/{likeId}")
	public Like getOneLike(@PathVariable int likeId) {
		return likeService.getOneLikeById(likeId);
	}
	
	@DeleteMapping("/{likeId}")
	public void deleteOneLike(@PathVariable int likeId) {
		likeService.deleteOneLikeById(likeId);
	}

}
