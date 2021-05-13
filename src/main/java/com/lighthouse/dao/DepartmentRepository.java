package com.lighthouse.dao;

import com.lighthouse.entity.Department;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>, JpaSpecificationExecutor<Department> {

    List<Department> findAllByName (Specification<Department> spec);
}
