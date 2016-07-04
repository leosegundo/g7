package br.ufc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloSpring {

	@RequestMapping("/helloSpring")
	public String helloSpring(){
		System.out.println("Entrei no Hello Spring!");
		
		return "hello_ok";
	}
	
	
}
