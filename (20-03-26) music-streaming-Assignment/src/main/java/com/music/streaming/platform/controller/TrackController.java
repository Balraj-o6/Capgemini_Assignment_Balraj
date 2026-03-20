package com.music.streaming.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.music.streaming.platform.dto.TrackRequest;
import com.music.streaming.platform.model.Track;
import com.music.streaming.platform.service.TrackService;

@RestController
@RequestMapping("music/platform/v1/tracks")
public class TrackController {
	
	@Autowired
	private TrackService ts;
	
	@PostMapping
	public ResponseEntity<Track> createNewTrack(@RequestBody TrackRequest ar) {
		return new ResponseEntity<Track>(ts.createTrack(ar),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Track>> getAllTrack(){
		return new ResponseEntity<List<Track>>(ts.getAllTracks(),HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Track> getTrackById(@PathVariable Long id) {
		return new ResponseEntity<Track>(ts.getTrackById(id),HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Track> updateTrack(@PathVariable Long id, @RequestBody TrackRequest ar) {
		return new ResponseEntity<Track>(ts.updateTrack(id, ar),HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteTrack(@PathVariable Long id) {
		ts.deleteTrack(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
