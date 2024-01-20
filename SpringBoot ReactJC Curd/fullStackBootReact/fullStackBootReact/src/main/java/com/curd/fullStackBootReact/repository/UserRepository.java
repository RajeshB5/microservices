package com.curd.fullStackBootReact.repository;

import com.curd.fullStackBootReact.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
