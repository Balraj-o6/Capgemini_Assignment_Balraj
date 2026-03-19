package com.cg.service;

import java.util.List;

import com.cg.dto.TraineeDTO;

public interface ITraineeService {
	public List<TraineeDTO> allTrainee();
	public List<TraineeDTO> getByName(String name);
	public TraineeDTO getById(int id);
	public String deleteTraineeById(int id);
	public TraineeDTO updateTrainee(TraineeDTO td);
	public TraineeDTO insertTrainee(TraineeDTO td);

}
