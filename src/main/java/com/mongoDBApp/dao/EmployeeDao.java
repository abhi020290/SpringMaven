package com.mongoDBApp.dao;

import java.util.List;


import com.mongoDBApp.bean.Employee;

public interface EmployeeDao {

 public void create(Employee employee);

 public void update(Employee employee);

 public int deleteById(int id);

 public Employee findById(int id);

 public List<Employee> findAll();

}