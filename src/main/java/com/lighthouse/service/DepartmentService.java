package com.lighthouse.service;

import com.lighthouse.dao.DepartmentRepository;
import com.lighthouse.entity.Department;
import com.lighthouse.entity.QDepartment;
import com.querydsl.core.types.dsl.BooleanTemplate;
import com.querydsl.core.types.dsl.Expressions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author huhan
 * @Description // 部门表服务层
 * @since 2020/12/5 9:01
 */
@Service
public class DepartmentService {

    @Autowired
    protected DepartmentRepository departmentRepository;

    //查询方法
    public List<Department> select(String name){
        return departmentRepository.findAll(new Specification<Department>() {
            @Override
            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //root实体映射,CriteriaBuilder条件构造器
                Predicate predicate =criteriaBuilder.like(root.get(QDepartment.department.name.getMetadata().getName()).as(String.class)
                        , "%"+name+"%");
                return predicate;
            }
        });
    }

    public List<Department> create(List<Department> departmentList){
        return departmentRepository.saveAll(departmentList);
    }

}
