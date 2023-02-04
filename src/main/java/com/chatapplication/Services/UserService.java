package com.chatapplication.Services;

import com.chatapplication.Entities.User;
import com.chatapplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired //dependency injection
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(User user) throws Exception{
        this.userRepository.save(user);
    }

    public User verifiedUser(User userLoginRequest) throws Exception{
        User foundUser = this.userRepository.findByUsernameAndPasswordOrderByCreatedAt(userLoginRequest.getUsername(), userLoginRequest.getPassword());

        if(foundUser == null){throw new Exception("usernane or password is incorrect");

        }

        return foundUser; // foundUser.getId() sometimes returning the ID of hte user only is needed
    }

    public User findUserById(Long userId) throws Exception {
        return this.userRepository.findById(userId).orElseThrow();
    }

}
