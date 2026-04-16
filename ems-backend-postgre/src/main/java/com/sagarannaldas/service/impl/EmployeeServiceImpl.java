package com.sagarannaldas.service.impl;

import org.springframework.stereotype.Service;

import com.sagarannaldas.dto.EmployeeDto;
import com.sagarannaldas.entity.Employee;
import com.sagarannaldas.mapper.EmployeeMapper;
import com.sagarannaldas.repository.EmployeeRepository;
import com.sagarannaldas.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(savedEmployee);
	}

}
