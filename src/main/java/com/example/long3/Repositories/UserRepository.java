package com.example.long3.Repositories;

import com.example.long3.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
    User loginUser(@Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT u FROM User u WHERE u.email = :email")
    User checkEmailExist(@Param("email") String email);

    @Query(value = "SELECT count(memberID) FROM User")
    Long countUserID();

    @Query(value = "SELECT u FROM User u WHERE u.memberID = :memberID")
    Optional<User> findUserByID(@Param("memberID") String memberID);
}
