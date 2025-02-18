package com.example.employee_management.repo;

import com.example.employee_management.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DepartmentRepo extends JpaRepository<Department, Long> {

}
