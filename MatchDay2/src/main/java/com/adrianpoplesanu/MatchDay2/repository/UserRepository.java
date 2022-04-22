package com.adrianpoplesanu.MatchDay2.repository;

import com.adrianpoplesanu.MatchDay2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByEmail(String email);
}
