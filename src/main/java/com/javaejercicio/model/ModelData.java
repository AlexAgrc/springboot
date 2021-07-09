package com.javaejercicio.model;

import java.io.Serializable;

public class ModelData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8869108288339781123L;
	private int code;
	private String mensaje;
	private boolean status;
	private String mensaje2;
	private boolean status2;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
		
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMensaje2() {
		return mensaje2;
	}
	public void setMensaje2(String mensaje2) {
		this.mensaje2 = mensaje2;
	}
	public boolean isStatus2() {
		return status2;
	}
	public void setStatus2(boolean status2) {
		this.status2 = status2;
	}
	
}
