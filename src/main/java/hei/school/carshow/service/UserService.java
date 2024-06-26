package hei.school.carshow.service;

import hei.school.carshow.db.entity.LoginRequest;
import hei.school.carshow.db.entity.User;
import hei.school.carshow.db.entity.enumm.Role;
import hei.school.carshow.repository.UserRepository;
import hei.school.carshow.service.configuration.JwtService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @SuppressWarnings("null")
    public Optional<User>  getUserById(String id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        user.setRole(Role.CLIENT);
        User save = userRepository.save(user);
        new InMemoryUserDetailsManager(save);
        return save;
    }

    @SuppressWarnings("null")
    public User updateUser(String id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();

            userToUpdate.setName(updatedUser.getName());
            userToUpdate.setEmail(updatedUser.getEmail());

            return userRepository.save(userToUpdate);
        } else {
            return null;
        }
    }

    @SuppressWarnings("null")
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    public User saveOrUpdate(User toSave){
        return userRepository.save(toSave);
    }

}
