package com.shanmathi.campusconnect.repository;

import com.shanmathi.campusconnect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}