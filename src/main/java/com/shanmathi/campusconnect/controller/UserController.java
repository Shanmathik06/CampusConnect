package com.shanmathi.campusconnect.controller;

import com.shanmathi.campusconnect.entity.*;
import com.shanmathi.campusconnect.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;
    private final CollegeRepository collegeRepository;
    private final DepartmentRepository departmentRepository;

    public UserController(UserRepository userRepository,
                          CollegeRepository collegeRepository,
                          DepartmentRepository departmentRepository) {
        this.userRepository = userRepository;
        this.collegeRepository = collegeRepository;
        this.departmentRepository = departmentRepository;
    }

    @PostMapping
    public User createUser(@RequestParam Long collegeId,
                           @RequestParam Long departmentId,
                           @RequestParam Role role,
                           @RequestBody User user) {

        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new RuntimeException("College not found"));

        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        user.setCollege(college);
        user.setDepartment(department);
        user.setRole(role);

        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}