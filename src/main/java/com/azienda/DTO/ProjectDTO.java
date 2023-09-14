package com.azienda.DTO;


import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

	private String projectName;
	
	private boolean status;
	
	private Date startTime;
	
	private Date endTime;
}
