package com.techbase.service.imp;

import com.techbase.dto.EmployeeDTO;
import com.techbase.entity.Employee;
import com.techbase.repository.EmployeeRepository;
import com.techbase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EmployeeImp implements EmployeeService {

    @Autowired
    private  EmployeeRepository employeeRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PageImpl<EmployeeDTO> getList(Pageable pageable) {
        Page<Employee> employeesPage = this.employeeRepository.findAll(pageable);
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();
        if (!employeesPage.getContent().isEmpty()) {
            employeeDTOs.addAll(employeesPage.stream().map(EmployeeDTO::from).collect(Collectors.toList()));
        }
        return new PageImpl<>(employeeDTOs, pageable, employeesPage.getTotalElements());
    }




}
