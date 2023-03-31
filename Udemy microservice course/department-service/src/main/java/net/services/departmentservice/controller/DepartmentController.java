package net.services.departmentservice.controller;

import lombok.AllArgsConstructor;
import net.services.departmentservice.dto.DepartmentDto;
import net.services.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //Build save Department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){

        DepartmentDto savedDTO = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDTO, HttpStatus.CREATED);
    }

    //Build get department by code
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("department-code") String code){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
}
