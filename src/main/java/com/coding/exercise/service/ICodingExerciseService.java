package com.coding.exercise.service;

import com.coding.exercise.domain.Quiz;

public interface ICodingExerciseService {

	public Quiz getQuizByAmountAndCategory(int amount, int category);

}
