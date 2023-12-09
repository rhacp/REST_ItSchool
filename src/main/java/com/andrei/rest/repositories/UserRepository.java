package com.andrei.rest.repositories;

import com.andrei.rest.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    List<User> findByFirstNameAndOrderByFirstNameAsc(String firstName);
    List<User> findByFirstName(String firstName) ;
}
