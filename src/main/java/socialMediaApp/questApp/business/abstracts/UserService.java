package socialMediaApp.questApp.business.abstracts;

import java.util.List;

import socialMediaApp.questApp.entities.User;

public interface UserService {
	List<User> getAll();
	User saveOneUser(User newUser);
	User getOneUserById(int userId);
	User updateOneUser(int userId, User newUser);
	void deleteById(int userId); 
}
