package com.techbase.service;

import com.techbase.dto.EmployeeDTO;
import com.techbase.entity.Employee;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    PageImpl<EmployeeDTO> getList(Pageable pageable);
}
