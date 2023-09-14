package com.azienda.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azienda.DTO.EmployeeDTO;
import com.azienda.DTO.ProjectDTO;
import com.azienda.entity.Employee;
import com.azienda.entity.Project;
import com.azienda.repository.EmployeeRepository;
import com.azienda.repository.ProjectRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AziendaService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	public EmployeeDTO creaNuovoDipendente(EmployeeDTO nuovoDipendente) {
		if(nuovoDipendente==null||nuovoDipendente.getPersonName()==null) return null;
	Employee e = new Employee();
	e.setPersonName(nuovoDipendente.getPersonName());
	e.setRole(nuovoDipendente.getRole());
	e.setSalary(nuovoDipendente.getSalary());
	e=employeeRepository.save(e);
	EmployeeDTO eDTO = new EmployeeDTO();
	eDTO.setPersonName(e.getPersonName());
	eDTO.setRole(e.getRole());
	eDTO.setSalary(e.getSalary());
		return eDTO;
	}
	
	public EmployeeDTO trovaPerId(int numeroId){
		Optional<Employee> eToFind =employeeRepository.findById(numeroId);
		if(eToFind.isPresent()) {
			Employee e= eToFind.get();
		EmployeeDTO eDTO = new EmployeeDTO();
		eDTO.setPersonName(e.getPersonName());
		eDTO.setRole(e.getRole());
		eDTO.setSalary(e.getSalary());
			return eDTO;
		} else {
			log.error("Dipendente con {} id non trovato!",numeroId);
			return null;
		}
	}
	
	public ProjectDTO creaNuovoProgetto(ProjectDTO nuovoProgetto) {
	Project p =new Project();
	p.setProjectName(nuovoProgetto.getProjectName());
	p.setStatus(nuovoProgetto.isStatus());
	p.setStartTime(nuovoProgetto.getStartTime());
	p.setEndTime(nuovoProgetto.getEndTime());
	p=projectRepository.save(p);
	ProjectDTO pDTO = new ProjectDTO();
	pDTO.setProjectName(p.getProjectName());
	pDTO.setStatus(p.isStatus());
	pDTO.setStartTime(p.getStartTime());
	pDTO.setEndTime(p.getEndTime());
	return pDTO;	
	}

}
