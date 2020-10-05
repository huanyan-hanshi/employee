package com.lin.controller;

import com.lin.pojo.Employee;
import com.lin.pojo.Error;
import com.lin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute("employee")
    public Employee getEmployee(){
        Employee employee=new Employee();
        return employee;
    }

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/get/{id}")
    public String get(@PathVariable("id")int id){
        return employeeService.get(id).toString();
    };

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id){
        employeeService.delete(id);
        return "redirect:/";
    };

    @PostMapping("/add")
    public String add(@Valid Employee employee, BindingResult bindingResult){
        if (bindingResult.hasErrors())return Error.ERROR.toString();
        else {
            employeeService.add(employee);
            return "redirect:/";
        }

    };

    @PostMapping("/update")
    public String update(@Valid Employee employee,BindingResult bindingResult){
        if (bindingResult.hasErrors())return Error.ERROR.toString();
        else {
            employeeService.update(employee);
            return "redirect:/";
        }
    };
}
