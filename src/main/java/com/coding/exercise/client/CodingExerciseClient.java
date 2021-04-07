package com.coding.exercise.client;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.coding.exercise.domain.CodingExerciseList;

@Component
@EnableAsync
public class CodingExerciseClient {

	private final String URL = "https://opentdb.com/api.php?amount=";

	private final String SUR_FIX = "&category=";

	public CodingExerciseList getQuizByAmountAndCategory(int amount, int category) {
		return new RestTemplate().getForEntity(URL + amount + SUR_FIX + category, CodingExerciseList.class).getBody();

	}

}
