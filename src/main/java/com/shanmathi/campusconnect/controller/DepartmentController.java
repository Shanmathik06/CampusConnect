package com.shanmathi.campusconnect.controller;

import com.shanmathi.campusconnect.entity.Department;
import com.shanmathi.campusconnect.entity.College;
import com.shanmathi.campusconnect.repository.DepartmentRepository;
import com.shanmathi.campusconnect.repository.CollegeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final CollegeRepository collegeRepository;

    public DepartmentController(DepartmentRepository departmentRepository,
                                CollegeRepository collegeRepository) {
        this.departmentRepository = departmentRepository;
        this.collegeRepository = collegeRepository;
    }

    // Create Department
    @PostMapping
    public Department createDepartment(@RequestParam Long collegeId,
                                       @RequestBody Department department) {

        College college = collegeRepository.findById(collegeId)
                .orElseThrow(() -> new RuntimeException("College not found"));

        department.setCollege(college);

        return departmentRepository.save(department);
    }

    // Get All Departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}