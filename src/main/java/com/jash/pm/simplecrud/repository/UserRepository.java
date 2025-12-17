package com.jash.pm.simplecrud.repository;

import com.jash.pm.simplecrud.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = "profile")
    @Query("select u from User u")
    List<User> findAllWithProfile();
}
