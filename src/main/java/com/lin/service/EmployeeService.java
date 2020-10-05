package com.lin.service;

import com.lin.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee get(int id);
    public int delete(int id);
    public int add(Employee employee);
    public int update(Employee employee);
    public List<Employee> gets();
}
