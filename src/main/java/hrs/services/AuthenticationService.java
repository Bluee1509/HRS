package hrs.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import hrs.dtos.LoginUserDto;
import hrs.dtos.RegisterUserDto;
import hrs.entities.User;
import hrs.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;

	public AuthenticationService(UserRepository userRepository, AuthenticationManager authenticationManager,
			PasswordEncoder passwordEncoder) {
		this.authenticationManager = authenticationManager;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

//	public User signup(RegisterUserDto input) {
//		User user = new User().setFullName(input.getFullName()).setEmail(input.getEmail())
//				.setPassword(passwordEncoder.encode(input.getPassword()));
//
//		return userRepository.save(user);
//	}

	public User authenticate(LoginUserDto input) {
//		authenticationManager
//				.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
//		System.out.println("asdasdasd");
		User user = userRepository.findByEmail(input.getEmail());
//		System.out.println("ssssss");
		return user;
	}

	public List<User> allUsers() {
		List<User> users = new ArrayList<>();

		userRepository.findAllUsers().forEach(users::add);

		return users;
	}
}
