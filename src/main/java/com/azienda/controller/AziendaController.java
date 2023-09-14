package com.azienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azienda.DTO.EmployeeDTO;
import com.azienda.DTO.ProjectDTO;
import com.azienda.exceptions.EmployeeCreationException;
import com.azienda.exceptions.EmployeeNotFoundException;
import com.azienda.service.AziendaService;
import com.azienda.utility.JsonResponseDTO;

@RestController
@RequestMapping(value = "/aziendacrm/api")
public class AziendaController {

	@Autowired
	AziendaService aziendaService;

	@GetMapping(value = "/{messaggioCustom}/{numero}")
	public String helloWorld(@PathVariable String messaggioCustom, @PathVariable int numero) {
		if (numero > 5)
			return messaggioCustom;
		else {
			return "numero non valido,messaggio non stampato";
		}
	}

	@GetMapping(value = "/messaggioCustom")
	public String helloWorld2(@RequestParam String messaggioCustom, @RequestParam int numero) {
		if (numero > 5)
			return messaggioCustom;
		else {
			return "numero non valido,messaggio non stampato";
		}
	}

	@GetMapping(value = "/findById")
	public ResponseEntity<JsonResponseDTO<?>> findById(@RequestParam int numeroId) {
		EmployeeDTO dipendente = new EmployeeDTO();
		JsonResponseDTO<?> bodyRisposta;
		if (numeroId > 0) {
			dipendente = aziendaService.trovaPerId(numeroId);
			if (dipendente != null) {
				bodyRisposta = new JsonResponseDTO<>(JsonResponseDTO.SUCCESS, HttpStatus.OK.value(), dipendente);
				return ResponseEntity.ok(bodyRisposta);
			}
		}
		bodyRisposta = new JsonResponseDTO<>(JsonResponseDTO.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),new EmployeeNotFoundException("Errore nella ricerca del dipendente,controlla il num inserito"));
		return ResponseEntity.badRequest().body(bodyRisposta);

	}

	@PostMapping(value = "/newEmployee")
	public ResponseEntity<JsonResponseDTO<?>> newEmployee(@RequestBody EmployeeDTO nuovoDipendente) {
		EmployeeDTO dipendente = new EmployeeDTO();
		JsonResponseDTO<?> bodyRisposta;
		dipendente = aziendaService.creaNuovoDipendente(nuovoDipendente);
		if (dipendente != null) {
			bodyRisposta = new JsonResponseDTO<>(JsonResponseDTO.SUCCESS, HttpStatus.OK.value(), dipendente);
			return ResponseEntity.ok(bodyRisposta);
		} else
			bodyRisposta = new JsonResponseDTO<>(JsonResponseDTO.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(),
					new EmployeeCreationException("Errore nella creazione del dipendente"));
		return ResponseEntity.badRequest().body(bodyRisposta);
	}

	@PostMapping(value = "/newProject")
	public ResponseEntity<?> newProject(@RequestBody ProjectDTO nuovoProgetto) {
		ProjectDTO progetto = new ProjectDTO();
		progetto = aziendaService.creaNuovoProgetto(nuovoProgetto);
		if (progetto != null) {
			return ResponseEntity.ok(progetto);
		} else {
			return ResponseEntity.badRequest().body("Progetto è null");
		}
	}

}
