package com.shanmathi.campusconnect.controller;

import com.shanmathi.campusconnect.entity.College;
import com.shanmathi.campusconnect.repository.CollegeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    private final CollegeRepository collegeRepository;

    public CollegeController(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    @PostMapping
    public College createCollege(@RequestBody College college) {
        return collegeRepository.save(college);
    }

    @GetMapping
    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }
}