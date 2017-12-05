package doko.database.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUser(String idString) {
		try {
			Long id = new Long(idString);
			return getUser(id);
		} catch (Exception e) {
			return Optional.ofNullable(null);
		}
	}

	public Optional<User> getUser(Long id) {
		if (id == null) {
			return Optional.ofNullable(null);
		} else {
			return Optional.ofNullable(userRepository.findOne(id));
		}
	}

	public Optional<User> getUserByName(String username) {
		return Optional.ofNullable(userRepository.findByUsername(username));
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
