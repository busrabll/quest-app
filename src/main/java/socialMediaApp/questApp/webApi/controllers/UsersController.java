package socialMediaApp.questApp.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import socialMediaApp.questApp.business.abstracts.UserService;
import socialMediaApp.questApp.entities.User;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {
	
	private UserService userService;
	
	@GetMapping
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@PostMapping
	public User createUser(@RequestBody User newUser) {
		return userService.saveOneUser(newUser);
	}
	
	@GetMapping("/{userId}")
	public User getOneUser(@PathVariable int userId) {
		return userService.getOneUser(userId);
	}
	
	@PutMapping("/{userId}")
	public User updateOneUser(@PathVariable int userId, @RequestBody User newUser) {
		return userService.updateOneUser(userId, newUser);
	}
	
	@DeleteMapping("/{userId}")
	public void deleteOneUser(@PathVariable int userId) {
		userService.deleteById(userId);
		
	}
}
