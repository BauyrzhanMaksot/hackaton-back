package com.example.epam1.repository;

import com.example.epam1.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bauka on 16-Mar-19
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String s);
}
