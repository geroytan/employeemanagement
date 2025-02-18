package com.example.employee_management.repo;

import com.example.employee_management.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProjectRepo extends JpaRepository<Project, Long>{

}
