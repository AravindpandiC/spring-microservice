package com.example.employeeservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDeptDto {
    EmployeeDto employeeDto;
    DepartmentDto departmentDto;
}
