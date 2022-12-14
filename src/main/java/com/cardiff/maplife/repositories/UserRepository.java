package com.cardiff.maplife.repositories;


import com.cardiff.maplife.entities.Event;
import com.cardiff.maplife.entities.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //save the user
    User save(User user);

    //find all users
//    Set<User> findAllUser();

//    //find user by id
//    Optional<User> findAllById(long id);
    User findById(long id);
    // find user by username
//    Optional<User> findUserByUsername(String username);
    User findUserByUsername(String username);
    //find username and password
//    Optional<User> findUserByPassword(String password);


    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query(value = "select u from User u where (u.username  LIKE %:key% ) ")
    List<User> searchResults(String key);



}
