package com.shanmathi.campusconnect.repository;

import com.shanmathi.campusconnect.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}