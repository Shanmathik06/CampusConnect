package com.shanmathi.campusconnect.repository;

import com.shanmathi.campusconnect.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepository extends JpaRepository<College, Long> {
}