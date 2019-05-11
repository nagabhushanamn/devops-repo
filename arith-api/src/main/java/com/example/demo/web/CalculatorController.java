package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.CalculatorService;

@RestController
@RequestMapping("/api/arith")
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;

	@GetMapping
	public double doArith(@RequestParam double n1,@RequestParam double n2,@RequestParam String op) {
		switch (op) {
		case "add":
			return this.calculatorService.add(n1, n2);
		default:
			throw new IllegalArgumentException("Invalid Arith");
		}
	}

	@ExceptionHandler(value = { IllegalArgumentException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public @ResponseBody String name(Throwable e) {
		return e.getMessage();
	}

}
