package com.sagarannaldas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sagarannaldas.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
