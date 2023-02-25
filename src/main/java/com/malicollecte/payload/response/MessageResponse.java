package com.malicollecte.payload.response;

public class MessageResponse {
	private String message;

	private int statut;

	public MessageResponse(String message, int statut) {
	    this.message = message;
		this.statut = statut;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
