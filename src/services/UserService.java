package services;

import models.UserModel;
import repositories.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public List<UserModel> getAllUser() {
        return this.userRepository.getAllUser();
    }

    public void deleteUser(int id) {
        this.userRepository.deleteUser(id);
    }

    public UserModel getUserByEmail(String email){
        return this.userRepository.getUserByEmail(email);
    }
}
