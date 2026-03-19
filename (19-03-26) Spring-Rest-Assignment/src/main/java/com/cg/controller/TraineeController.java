package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.TraineeDTO;
import com.cg.service.ITraineeService;

@RestController
@RequestMapping("trainee")
public class TraineeController {

	@Autowired
	private ITraineeService service;

	@GetMapping(produces = { "application/json", "application/xml" })
	public List<TraineeDTO> getXyz() {
		return service.allTrainee();
	}

	@GetMapping("name/{name}")
	public List<TraineeDTO> getByName(@PathVariable String name) {
		return service.getByName(name);
	}

	@GetMapping("/{id}")
	public TraineeDTO getById(@PathVariable int id) {
		return service.getById(id);
	}

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		return service.deleteTraineeById(id);
	}

	@PutMapping
	public TraineeDTO updateTrainee(@RequestBody TraineeDTO td) {
		return service.updateTrainee(td);
	}

	@PostMapping
	public TraineeDTO createTrainee(@RequestBody TraineeDTO td) {
		return service.insertTrainee(td);
	}
}
