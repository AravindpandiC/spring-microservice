package com.example.employeeservice.service;

import com.example.employeeservice.dto.DepartmentDto;
import com.example.employeeservice.dto.EmployeeDeptDto;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient webClient;

    @Autowired
    APIClient apiClient;
    public EmployeeDto addEmployee(EmployeeDto employeeDto){
        Employee employee = modelMapper.map(employeeDto,Employee.class);
        employeeRepository.save(employee);
        return employeeDto;
    }

    public EmployeeDeptDto getEmployee(int id){
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid id"));
        ResponseEntity<DepartmentDto> dtoResponseEntity = restTemplate.getForEntity("http://localhost:8080/department/" + employee.getDeptCode(), DepartmentDto.class);

//        DepartmentDto departmentDto = webClient.get()
//                .uri("http://localhost:8080/department/" + employee.getDeptCode())
//                .retrieve()
//                .bodyToMono(DepartmentDto.class)
//                .block();

       // DepartmentDto departmentDto = apiClient.getDepartment(employee.getDeptCode());
        DepartmentDto departmentDto = dtoResponseEntity.getBody();
        EmployeeDto employeeDto = modelMapper.map(employee,EmployeeDto.class);
        EmployeeDeptDto employeeDeptDto = EmployeeDeptDto.builder().departmentDto(departmentDto).employeeDto(employeeDto).build();
        return employeeDeptDto;
    }
}
