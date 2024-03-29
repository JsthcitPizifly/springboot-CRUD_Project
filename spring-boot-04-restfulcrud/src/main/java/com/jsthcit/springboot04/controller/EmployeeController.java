package com.jsthcit.springboot04.controller;

import com.jsthcit.springboot04.dao.DepartmentDao;
import com.jsthcit.springboot04.dao.EmployeeDao;
import com.jsthcit.springboot04.entities.Department;
import com.jsthcit.springboot04.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    //查询员工列表
    @GetMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);

        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //来到添加页面，查出所有部门在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee) {

        employeeDao.save(employee);

        //回到员工列表页面
        return "redirect:/emps";
    }

    //Edit page
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        //显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        //回到修改页面
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
