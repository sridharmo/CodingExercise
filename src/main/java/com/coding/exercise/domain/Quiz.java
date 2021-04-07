package com.coding.exercise.domain;

import java.util.List;

import com.coding.exercise.web.rest.dto.CodingExerciseListDTO;

public class Quiz {

	private List<CodingExerciseListDTO> quiz;

	public List<CodingExerciseListDTO> getQuiz() {
		return quiz;
	}

	public void setQuiz(List<CodingExerciseListDTO> quiz) {
		this.quiz = quiz;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((quiz == null) ? 0 : quiz.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quiz other = (Quiz) obj;
		if (quiz == null) {
			if (other.quiz != null)
				return false;
		} else if (!quiz.equals(other.quiz))
			return false;
		return true;
	}

}
