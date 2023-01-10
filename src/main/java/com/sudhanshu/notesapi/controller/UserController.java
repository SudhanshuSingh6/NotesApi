package com.sudhanshu.notesapi.controller;
import com.sudhanshu.notesapi.model.User;
import com.sudhanshu.notesapi.repository.NotesRepository;
import com.sudhanshu.notesapi.repository.UserRepository;
import com.sudhanshu.notesapi.request.AddUserReq;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;
    private NotesRepository notesRepository;

    public UserController(UserRepository userRepository, NotesRepository notesRepository) {
        this.userRepository = userRepository;
        this.notesRepository = notesRepository;
    }
    @GetMapping("/{userId}")
    public String login(@RequestBody AddUserReq addUserReq){
       User user= userRepository.findById(addUserReq.getUsername()).orElseThrow(() -> new NoSuchElementException());
       if(user.getPassword().equals(addUserReq.getPassword()))
           return user.toString();
       else
           return  "No User Found";
    }
    @PostMapping("/adduser")
    public User addUser(@RequestBody AddUserReq userRequest){
        User user = new User();
        user.setUsername((userRequest.getUsername()));
        user.setPassword(userRequest.getPassword());
        return userRepository.save(user);
    }
}
