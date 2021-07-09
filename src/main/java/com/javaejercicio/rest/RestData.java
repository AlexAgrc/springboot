package com.javaejercicio.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaejercicio.model.ModelData;

@RestController
@RequestMapping(path = "/rest/data")
public class RestData {
	
	@GetMapping(path = "/obtenerDatos", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ModelData getData(@RequestParam(name = "msg") String message){
		ModelData response = new ModelData();
		char[] aCaracteres = message.toCharArray();
		List<String> elementos = new ArrayList<String>();
		List<String> cntelementos = new ArrayList<String>();
		boolean resultado=false;
		boolean resultado2=false;
		
		if (aCaracteres.length != 0) {
		
		/*Pregunta N° 1*/	
			for (int i = 0; i < aCaracteres.length; i++) {
				
				for (int j = 0; j < i; j++) {
			        if (aCaracteres[i]==aCaracteres[j]) {
			        	elementos.add(""+aCaracteres[i]);
			        }
			    }
				
			}
			
			for (int i = 0; i < aCaracteres.length; i++) {
					if(elementos.contains(""+aCaracteres[i])){
						resultado=true;
					}else {
						resultado=false;
					}
				if (resultado==false) {
					break;
				}
			}
			
			/*Pregunta N° 2*/	
			if (resultado==true) {
				
				Arrays.sort(aCaracteres);
				int contador=0;
		        int aux=aCaracteres[0];
		        for (int i = 0; i < aCaracteres.length; i++) {
		            if(aux == aCaracteres[i]){
		                contador++;
		            } else {
		                cntelementos.add(""+contador);
		                contador=1;
		                aux=aCaracteres[i];
		            }
		        }
		        cntelementos.add(""+contador);
		        
		        for(int i = 0; i != cntelementos.size(); ++i)
		        {
		        	for (int j = 0; j < i; j++) {
		        		if (!cntelementos.get(i).equals(cntelementos.get(j))) {
				        	resultado2=true;
				        	break;
				        }else {
				        	resultado2=false;
				        }
				    }
		        	if(resultado2==true) {
		        		break;
		        	}
		        }
		        
			}
			
			response.setCode(100);
			response.setStatus(resultado);
			response.setMensaje("Cadena recibida.."+message+" ¿1.Todos los Valores son Repetidos? ");
			response.setStatus2(resultado2);
			response.setMensaje2("¿2.Todos son Repetidos con alguno menos? ");
			
		} else {
			response.setCode(401);
			response.setStatus(resultado);
			response.setMensaje("Ingresar un valor... "+message);
			response.setStatus2(resultado2);
			response.setMensaje2("");
		}
		
		return response;
	}
		
}
