package com.techbase.controller;

import com.techbase.dto.EmployeeDTO;
import com.techbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/search")
    public ResponseEntity<Page<EmployeeDTO>> search(Pageable pageable) {
        return ResponseEntity.ok(this.employeeService.getList(pageable));
    }
}
