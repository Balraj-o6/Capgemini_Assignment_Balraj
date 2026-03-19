package com.cg.dto;

import com.cg.entity.Trainee;

public class EntityManager {
	public static Trainee convertObjectToEntity(TraineeDTO trd) {
		return new Trainee(trd.getTraineeName(), trd.getTraineeDomain(), trd.getTraineeLocation());

	}

	public static TraineeDTO convertEntityToObject(Trainee trd) {
		return new TraineeDTO(trd.getTraineeId(), trd.getTraineeName(), trd.getTraineeDomain(),
				trd.getTraineeLocation());
	}
}
