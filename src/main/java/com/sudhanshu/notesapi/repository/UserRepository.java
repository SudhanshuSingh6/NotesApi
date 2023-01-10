package com.sudhanshu.notesapi.repository;

import com.sudhanshu.notesapi.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {

    public User findByUsername(String username);
}