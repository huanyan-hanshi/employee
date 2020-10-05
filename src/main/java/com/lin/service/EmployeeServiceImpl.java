package com.lin.service;

import com.lin.dao.EmployeeDao;
import com.lin.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Employee get(int id) {
        return employeeDao.get(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(int id) {
        return employeeDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int add(Employee employee) {
        return employeeDao.add(employee);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public List<Employee> gets() {
        return employeeDao.gets();
    }
}
