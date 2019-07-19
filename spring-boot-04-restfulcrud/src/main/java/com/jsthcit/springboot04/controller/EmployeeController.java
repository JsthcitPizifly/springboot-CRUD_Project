package com.jsthcit.springboot04.controller;

import com.jsthcit.springboot04.dao.EmployeeDao;
import com.jsthcit.springboot04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;


@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    //查询员工列表
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);

        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage() {

        return "add";
    }
}
