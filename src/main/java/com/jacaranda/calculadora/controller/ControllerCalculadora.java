package com.jacaranda.calculadora.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.models.Calculadora;

@Controller
public class ControllerCalculadora {
	
	@GetMapping("/calculadora")
	public String calculadora(Model model) {
	    Calculadora cal = new Calculadora();
	    model.addAttribute("calculadora", cal);
	    return "index";
	}
	
	@GetMapping("/resolver")
	public String resolver(Model model, @ModelAttribute("calculadora") Calculadora cal2) {
		Calculadora cal = new Calculadora();
	    model.addAttribute("calculadora", cal);
	    String resul = "El resultado de " + cal2.getNumero1() +" "+cal2.getOperador()+" "+ cal2.getNumero2() + " es: " + cal2.calcular();
	    model.addAttribute("resul", resul);
	    
	    // Redirigir a una nueva vista que muestre el resultado
	    return "index";
	}
	
}
