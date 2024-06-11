package com.evaluation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.service.NumberTransformer;

@RestController
@RequestMapping("api")
public class NumberTransformationController {

	@Autowired
	private NumberTransformer numberTransformer;

	@GetMapping("/transform/{number}")
	public ResponseEntity<String> getTransformedNumber(@PathVariable int number) {
		return new ResponseEntity<>(this.numberTransformer.transform(number), HttpStatus.OK);
	}

}
