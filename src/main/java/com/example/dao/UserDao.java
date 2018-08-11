package com.example.dao;

import com.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserDao extends JpaRepository<User,Long> {
}
