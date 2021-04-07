package com.coding.exercise.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coding.exercise.domain.Quiz;
import com.coding.exercise.service.ICodingExerciseService;

/**
 * REST controller for exercise .
 */
@RestController
@RequestMapping("/coding/exercise")
@EnableAsync
public class CodingExerciseResource {

	@Autowired
	private ICodingExerciseService service;

	@GetMapping("/quiz")
	public ResponseEntity<Quiz> fetchQuizByAmountAndCategory(@RequestParam int amount, @RequestParam int category) {

		return new ResponseEntity<Quiz>(service.getQuizByAmountAndCategory(amount, category), HttpStatus.FOUND);
	}

}
