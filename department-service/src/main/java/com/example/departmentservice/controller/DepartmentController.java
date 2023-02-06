package com.example.departmentservice.controller;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping()
    public DepartmentDto addDept(@RequestBody DepartmentDto departmentDto){
        DepartmentDto dto = departmentService.addDept(departmentDto);
        return dto;
    }

    @GetMapping("{deptCode}")
    public DepartmentDto getDept(@PathVariable String deptCode){
        DepartmentDto dto = departmentService.getDept(deptCode);
        return dto;
    }
}
