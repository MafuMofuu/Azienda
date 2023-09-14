package com.azienda.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonResponseDTO<T> {

	private String message;
	
	private int status;
	
	private T body;
	
	public static final String SUCCESS="La Richiesta è andata a buon fine,bravi tutti!";
	
	public static final String BAD_REQUEST="Errore nella richiesta";
	
	public static final String INTERNAL_SERVER_ERROR="Errore inaspettato nel codice";
	
	
	
}
