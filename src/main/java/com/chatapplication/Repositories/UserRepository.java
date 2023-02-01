package com.chatapplication.Repositories;

import com.chatapplication.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository //ALL REPOSITORIES ALWAYS INTERFACES
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsernameAndPasswordOrderByCreatedAt(String username, String password);

    @Override
    ArrayList<User> findAll();

    @Override
    Optional<User> findById(Long aLong);
}
