package net.services.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.services.departmentservice.dto.DepartmentDto;
import net.services.departmentservice.entity.Department;
import net.services.departmentservice.repository.DepartmentRepository;
import net.services.departmentservice.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;


    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = modelMapper.map(departmentDto, Department.class);

        Department saveDepartment = departmentRepository.save(department);

        DepartmentDto savedDto = modelMapper.map(saveDepartment, DepartmentDto.class);
        return savedDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code){
        Department department = departmentRepository.findByDepartmentCode(code);
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        return departmentDto;
    }
}
