package com.example.employeeservice.controller;

import com.example.employeeservice.dto.EmployeeDeptDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping()
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto dto = employeeService.addEmployee(employeeDto);
        return dto;
    }

    @GetMapping("{id}")
    public EmployeeDeptDto getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }
}
