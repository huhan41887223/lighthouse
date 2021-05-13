package com.lighthouse.api;

import com.lighthouse.entity.Department;
import com.lighthouse.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;


@Api(tags = "患者手术信息")
@Slf4j
@RestController
@RequestMapping("dt/dpa")
public class DepartementController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping(value = "/select")
    @ResponseBody
    public List<Department> callable(@RequestParam(value = "name") String name) {
        return departmentService.select(name);
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public List<Department> create(@RequestBody List<Department> departmentList) {
        return departmentService.create(departmentList);
    }



}
