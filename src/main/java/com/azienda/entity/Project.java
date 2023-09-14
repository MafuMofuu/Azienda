package com.azienda.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	@Column(name = "project_name")
	private String projectName;
	@Column
	private boolean status;
	@Column(name = "start_time")
	private Date startTime;
	@Column(name = "end_time")
	private Date endTime;
	@ManyToMany
	@JoinColumn(name = "project_members",referencedColumnName ="active_projects" )
	private List<Employee>projectMembers;
    
}
