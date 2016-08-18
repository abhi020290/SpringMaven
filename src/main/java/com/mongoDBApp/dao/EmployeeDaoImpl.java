package com.mongoDBApp.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.mongoDBApp.bean.Employee;
import com.mongodb.WriteResult;


public class EmployeeDaoImpl implements EmployeeDao {

 private static final String COLLECTION = "Employee";

 @Autowired
 MongoTemplate mongoTemplate;

 public void create(Employee employee) {
  if (employee != null) {
   this.mongoTemplate.insert(employee, COLLECTION);
  }
 }

 @Override
 public Employee findById(int id) {
  Query query = new Query(Criteria.where("_id").is(id));
  return this.mongoTemplate.findOne(query, Employee.class, COLLECTION);
 }

 @Override
 public int deleteById(int id) {

  Query query = new Query(Criteria.where("_id").is(id));
  WriteResult result = this.mongoTemplate.remove(query, Employee.class,
    COLLECTION);
  return result.getN();
 }

 @Override
 public void update(Employee employee) {
  if (employee != null) {
   this.mongoTemplate.save(employee, COLLECTION);
  }
 }

 @Override
 public List<Employee> findAll() {
  return (List<Employee>) mongoTemplate.findAll(Employee.class,
    COLLECTION);
 }

}