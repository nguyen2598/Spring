package com.nguyen.identity_service.service;

import com.nguyen.identity_service.dto.request.UserCreationRequest;
import com.nguyen.identity_service.dto.request.UserUpdateRequest;
import com.nguyen.identity_service.entity.User;
import com.nguyen.identity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        if(userRepository.existsByUsername(request.getUsername())){
            throw new RuntimeException("User existed");
        }
        user.setEmail(request.getEmail());
        user.setExt(request.getExt());
        user.setPassword(request.getPassword());
        user.setRole_id(request.getRole_id());
        return userRepository.save(user);
    }
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUser(String id) {
     return userRepository.findById(id)
             .orElseThrow(
                     () -> new RuntimeException("User not found")// day la lambda
             );
    }
    public User updateUser(String userId,UserUpdateRequest request) {
        User user = getUser(userId);
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
