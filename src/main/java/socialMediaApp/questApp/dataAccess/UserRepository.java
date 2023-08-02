package socialMediaApp.questApp.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import socialMediaApp.questApp.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
