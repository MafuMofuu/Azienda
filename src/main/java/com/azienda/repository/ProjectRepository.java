package com.azienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.azienda.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>  {

}
