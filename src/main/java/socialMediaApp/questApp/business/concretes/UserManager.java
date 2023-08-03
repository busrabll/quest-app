package socialMediaApp.questApp.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import socialMediaApp.questApp.business.abstracts.UserService;
import socialMediaApp.questApp.dataAccess.UserRepository;
import socialMediaApp.questApp.entities.User;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
	
	private UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User saveOneUser(User newUser) {
		return userRepository.save(newUser);
	}

	@Override
	public User getOneUserById(int userId) {
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public User updateOneUser(int userId, User newUser) {
		
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setPassword(newUser.getPassword());
			userRepository.save(foundUser);
			return foundUser;
		}
		else
			return null;
	}

	@Override
	public void deleteById(int userId) {
		userRepository.deleteById(userId);		
	}
}
