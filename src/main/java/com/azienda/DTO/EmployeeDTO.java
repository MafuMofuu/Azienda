package com.azienda.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //fornisce getter setter tostring hascode equals e required arguments constructor quelli obbligatori
@NoArgsConstructor //costruttire sebza argomenti
@AllArgsConstructor
public class EmployeeDTO {
	
	private String personName;
	
	private String role;
	
	private double salary;
	
}
