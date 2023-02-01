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

}
