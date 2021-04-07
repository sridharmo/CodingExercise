package com.coding.exercise.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import com.coding.exercise.client.CodingExerciseClient;
import com.coding.exercise.domain.CodingExerciseList;
import com.coding.exercise.domain.Quiz;
import com.coding.exercise.service.ICodingExerciseService;
import com.coding.exercise.web.rest.dto.CodingExerciseDTO;
import com.coding.exercise.web.rest.dto.CodingExerciseListDTO;

@Service
@EnableAsync
public class CodingExerciseServiceImpl implements ICodingExerciseService {

	@Autowired
	private CodingExerciseClient client;

	@Override
	public Quiz getQuizByAmountAndCategory(int amount, int category) {
		Quiz quiz = new Quiz();
		List<CodingExerciseListDTO> response = new LinkedList<CodingExerciseListDTO>();
		response.add(dataTransformation(client.getQuizByAmountAndCategory(amount, category)));
		quiz.setQuiz(response);
		return quiz;
	}

	private CodingExerciseListDTO dataTransformation(CodingExerciseList raw_response) {
		CodingExerciseListDTO dto = new CodingExerciseListDTO();
		List<CodingExerciseDTO> result = new LinkedList<>();
		raw_response.getResults().stream().forEach(quiz -> {
			dto.setCategory(quiz.getCategory());
			CodingExerciseDTO exerciseDTO = new CodingExerciseDTO();
			List<String> all_answers = quiz.getIncorrect_answers();
			all_answers.add(quiz.getCorrect_answer());
			exerciseDTO.setAll_answers(all_answers);
			exerciseDTO.setCorrect_answer(quiz.getCorrect_answer());
			exerciseDTO.setDifficulty(quiz.getDifficulty());
			exerciseDTO.setQuestion(quiz.getQuestion());
			exerciseDTO.setType(quiz.getType());
			result.add(exerciseDTO);
		});
		dto.setResults(result);
	   return dto;
	}

}
