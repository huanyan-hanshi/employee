package com.lin.dao;

import com.lin.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeDao {
    public Employee get(@Param("id")int id);
    public int delete(@Param("id")int id);
    public int add(Employee employee);
    public int update(Employee employee);
    public List<Employee> gets();

}
