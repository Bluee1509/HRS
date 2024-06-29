package hrs.repositories;

import hrs.entities.User;

import java.util.List;

public interface UserRepository {
	User findByEmail(String email);


	List<User> findAllUsers();

}