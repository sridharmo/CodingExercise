package com.coding.exercise.domain;

import java.util.List;

public class CodingExerciseList {
	
	private List<CodingExercise> results;

	public List<CodingExercise> getResults() {
		return results;
	}

	public void setResults(List<CodingExercise> results) {
		this.results = results;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((results == null) ? 0 : results.hashCode());
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
		CodingExerciseList other = (CodingExerciseList) obj;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		return true;
	}

}
