package com.nongoDBApp.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongoDBApp.bean.Employee;
import com.mongoDBApp.dao.EmployeeDao;

public class App {
 public static void main(String[] args) {

  ApplicationContext context = new ClassPathXmlApplicationContext(
    "spring-beans.xml");

  Employee yashwant = new Employee();
  yashwant.setFirstName("Yashwant");
  yashwant.setLastName("Chavan");
  yashwant.setId(100);

  Employee mahesh = new Employee();
  mahesh.setFirstName("Mahesh");
  mahesh.setLastName("Patil");
  mahesh.setId(200);

  EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
  employeeDao.create(yashwant);
  employeeDao.create(mahesh);
  
  System.out.println("List After Employee Creation");
  System.out.println("-----------------------------");

  for (Employee e : employeeDao.findAll()) {
   System.out.println(e);
  }
/*
  mahesh.setLastName("Patil -Update");
  employeeDao.update(mahesh);

  System.out.println("List After Employee Updation");
  System.out.println("-----------------------------");

  for (Employee e : employeeDao.findAll()) {
   System.out.println(e);
  }

  //employeeDao.deleteById(100);

  System.out.println("List After Employee Deletion");
  System.out.println("-----------------------------");

  for (Employee e : employeeDao.findAll()) {
   System.out.println(e);
  }
  
  System.out.println("Find By Id");
  System.out.println("-----------------------------");
  
  System.out.println(employeeDao.findById(200));
*/
 }
}