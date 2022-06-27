package com.emrap.app.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emrap.app.business.department.DepartmentService;
import com.emrap.app.dtos.FilterRequestDto;
import com.emrap.app.dtos.department.departmentCreateDto;
import com.emrap.app.dtos.department.departmentUpdateDto;
import com.emrap.app.dtos.department.updateLocationDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping("/api/department")
@Api(value = "Department Api documentation")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        super();
        this.departmentService = departmentService;
    }

    @PostMapping("/add")
    @ResponseBody
    @ApiOperation(value = "Adding new department")
    public ResponseEntity<?> add(@RequestBody departmentCreateDto dto) {
        return ResponseEntity.ok(departmentService.createDepartment(dto));
    }

    @GetMapping("/list")
    @ResponseBody
    @ApiOperation(value = "Listing departments")
    public ResponseEntity<?> list(@RequestParam(value = "pageNumber", required = true) int pageNumber,
            @RequestParam(value = "pageSize", required = true) int pageSize) {

        var filterRequestDto = new FilterRequestDto(pageNumber, pageSize);
        return ResponseEntity.ok(departmentService.getAllDepartments(filterRequestDto));
    }

    @PostMapping("/update")
    @ResponseBody
    @ApiOperation(value = "Update existing department")
    public ResponseEntity<?> update(@RequestBody departmentUpdateDto dto) {
        return ResponseEntity.ok(departmentService.updateDepartment(dto));
    }

    @PostMapping("/updateLocation")
    @ResponseBody
    @ApiOperation(value = "Update existing department's location")
    public ResponseEntity<?> updateLocation(@RequestBody updateLocationDto dto) {
        return ResponseEntity.ok(departmentService.updateOfficeLocation(dto));
    }

    @GetMapping("/get")
    @ResponseBody
    @ApiOperation(value = "Get existing department")
    public ResponseEntity<?> get(@RequestParam(value = "id", required = true) Long id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }

    @GetMapping("/delete")
    @ResponseBody
    @ApiOperation(value = "Delete existing department")
    public ResponseEntity<?> delete(@RequestParam(value = "id", required = true) Long id) {
        return ResponseEntity.ok("Department succesfully deleted.");
    }

}
