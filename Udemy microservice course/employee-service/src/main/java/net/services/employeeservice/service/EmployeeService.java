package net.services.employeeservice.service;

import net.services.employeeservice.dto.APIResponseDto;
import net.services.employeeservice.dto.EmployeeDto;
import net.services.employeeservice.entity.Employee;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long id);
}
