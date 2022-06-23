package com.emrap.app.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emrap.app.business.department.DepartmentService;
import com.emrap.app.core.utilities.results.Result;
import com.emrap.app.dtos.department.departmentCreateDto;

@CrossOrigin
@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody departmentCreateDto dto) {
        return ResponseEntity.ok(departmentService.createDepartment(dto));
    }

}
