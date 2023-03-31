package net.services.employeeservice.comtroller;

import lombok.AllArgsConstructor;
import net.services.employeeservice.dto.APIResponseDto;
import net.services.employeeservice.dto.EmployeeDto;
import net.services.employeeservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{employee-id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("employee-id") Long id){
        APIResponseDto responseEmployee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(responseEmployee, HttpStatus.OK);
    }
}
