package com.azienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azienda.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { //jpa vuole sapere su che tipo di entity sta lavorando e il tipo della sua chiave primaria

}
