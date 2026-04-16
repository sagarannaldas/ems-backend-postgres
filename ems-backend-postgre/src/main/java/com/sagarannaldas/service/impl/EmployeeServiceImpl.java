package com.sagarannaldas.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sagarannaldas.dto.EmployeeDto;
import com.sagarannaldas.entity.Employee;
import com.sagarannaldas.exception.ResourceNotFoundException;
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

	@Override
	public EmployeeDto findEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));

		return EmployeeMapper.mapToEmployeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();

		return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployeeDto) {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(
				() -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));
		
		employee.setEmail(updatedEmployeeDto.getEmail());
		employee.setFirstName(updatedEmployeeDto.getFirstName());
		employee.setLastName(updatedEmployeeDto.getLastName());
		
		Employee UpdatedEmployee = employeeRepository.save(employee);
		return EmployeeMapper.mapToEmployeeDto(UpdatedEmployee);
	}

}
