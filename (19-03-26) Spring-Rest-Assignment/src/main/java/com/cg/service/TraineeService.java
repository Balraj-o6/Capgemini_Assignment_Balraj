package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dto.EntityManager;

import com.cg.dto.TraineeDTO;

import com.cg.entity.Trainee;
import com.cg.repo.ITraineeRepo;

@Service
public class TraineeService implements ITraineeService {

	@Autowired
	private ITraineeRepo repo;
	
	

	@Override
	public List<TraineeDTO> allTrainee() {
		List<Trainee> emps = repo.findAll();
		List<TraineeDTO> empd = new ArrayList<>();
		emps.forEach(e -> empd.add(EntityManager.convertEntityToObject(e)));
		return empd;
	}

	@Override
	public List<TraineeDTO> getByName(String name) {
		List<Trainee> emps = repo.findByTraineeName(name);
		List<TraineeDTO> empd = new ArrayList<>();
		emps.forEach(e -> empd.add(EntityManager.convertEntityToObject(e)));
		return empd;
	}

	@Override
	public TraineeDTO getById(int id) {
		Optional<Trainee> op = repo.findById(id);
		if (op.isPresent()) {
			TraineeDTO t = EntityManager.convertEntityToObject(op.get());
			return t;
		} else
			return null;
	}

	@Override
	public String deleteTraineeById(int id) {
		if (getById(id) != null) {
			repo.deleteById(id);
			return "Employee Deleted....";
		} else {
			return "Employee not found";
		}
	}

	@Override
	public TraineeDTO updateTrainee(TraineeDTO td) {
		Optional<Trainee> op = repo.findById(td.getTraineeId());
		if (op.isPresent()) {
			Trainee t = EntityManager.convertObjectToEntity(td);
			t.setTraineeId(td.getTraineeId());
			Trainee t1 = repo.saveAndFlush(t);
			return EntityManager.convertEntityToObject(t1);
		} else
			return null;
	}

	@Override
	public TraineeDTO insertTrainee(TraineeDTO td) {
		Trainee e = repo.saveAndFlush(EntityManager.convertObjectToEntity(td));
		return EntityManager.convertEntityToObject(e);
	}

}
