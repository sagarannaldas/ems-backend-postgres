package com.sagarannaldas.mapper;

import com.sagarannaldas.dto.EmployeeDto;
import com.sagarannaldas.entity.Employee;

public class EmployeeMapper {

	public static EmployeeDto mapToEmployeeDto(Employee employee) {
		EmployeeDto employeeDto = EmployeeDto.builder().id(employee.getId()).email(employee.getEmail())
				.firstName(employee.getFirstName()).lastName(employee.getLastName()).build();

		return employeeDto;
	}

	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		Employee employee = Employee.builder().id(employeeDto.getId()).email(employeeDto.getEmail())
				.firstName(employeeDto.getFirstName()).lastName(employeeDto.getLastName()).build();
		return employee;
	}

}
