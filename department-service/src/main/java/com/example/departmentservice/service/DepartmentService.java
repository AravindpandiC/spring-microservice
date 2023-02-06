package com.example.departmentservice.service;

import com.example.departmentservice.dto.DepartmentDto;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ModelMapper modelMapper;
    public DepartmentDto addDept(DepartmentDto departmentDto){
        Department department = modelMapper.map(departmentDto,Department.class);
        departmentRepository.save(department);
        return departmentDto;
    }

    public DepartmentDto getDept(String deptCode){
        Department department = departmentRepository.findByDeptCode(deptCode).orElseThrow(()->new RuntimeException("No id"));
        DepartmentDto departmentDto = modelMapper.map(department,DepartmentDto.class);
        return departmentDto;
    }
}
