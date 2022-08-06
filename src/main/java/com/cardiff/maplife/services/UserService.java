package com.cardiff.maplife.services;

import com.cardiff.maplife.entities.User;
import com.cardiff.maplife.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private User currentUser;

    //this is not the best way to get the current user, but was sufficient for displaying our MVP to the client
    public void setCurrentUser(User user){
        this.currentUser = user;
    }

    //gets the currently logged-in user
    public User getCurrentUser(){
        return currentUser;
    }



    public UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
//    public Set<User> findAllUser(){
//        return userRepository.findAllUser();
//    }

    public  User findUserByUsername(String username){
        Optional<User> optionalUser=userRepository.findUserByUsername(username);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        else {
            return null;
        }
    }
    public User findUserByPassword(String password){
    Optional<User> optionalPassword =userRepository.findUserByPassword(password);
        if(optionalPassword.isPresent()){
        return optionalPassword.get();
    }
        else {
        return null;
    }
}







}
