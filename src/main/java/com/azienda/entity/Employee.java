package com.azienda.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //fornisce getter setter tostring hascode equals e required arguments constructor quelli obbligatori
@NoArgsConstructor //costruttire sebza argomenti
@AllArgsConstructor //costr con tutti gli argomenti 
@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id; 	
	@Column(name = "person_name")
	private String personName;
	@Column
	private String role;
	@Column
	private double salary;
	@Column(name ="active_projects")
	@ManyToMany(mappedBy = "projectMembers",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Project> activeProjects;
	
	
	
	
	
}
