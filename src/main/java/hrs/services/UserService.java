package hrs.services;

import org.springframework.stereotype.Service;
import hrs.entities.User;
import hrs.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> allUsers() {
		List<User> users = new ArrayList<>();
		
		userRepository.findAllUsers().forEach(users::add);
		
		return users;
	}
}