package com.revature.skilledge.repository;

import com.revature.skilledge.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    public List<Employee> findByName(String name);//property expressions


    public List<Employee> findBySalaryGreaterThan(int amount);
//
//    @Query("select e from employee e where e.salary < 10000")
//    List<Employee> findBySalaryBelow();






}

