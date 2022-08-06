package com.cardiff.maplife.loginAuthentication;


import com.cardiff.maplife.entities.User;
import com.cardiff.maplife.repositories.UserRepository;
import com.cardiff.maplife.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StreamerDetailsService implements UserDetailsService
{
    @Autowired
    UserRepository userRepo;

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        //pass username to UserRepository to get user with specified username
        Optional<User> user = userRepo.findUserByUsername(username);
        //throw exception if no user found
        user.orElseThrow(() -> new UsernameNotFoundException("Not found " + username));
        //add the currently logged-in user object to the userService.
        userService.setCurrentUser(user.get());
        //return the user from optional
        return user.map(StreamerUserDetails::new).get();
    }





}
