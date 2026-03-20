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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.streaming.platform.dto.PlayListRequest;
import com.music.streaming.platform.model.PlayList;
import com.music.streaming.platform.service.PlayListService;

@RestController
@RequestMapping("music/platform/v1/playlists")
public class PlayListController {
	
	@Autowired
	private PlayListService ps;
	
	@PostMapping
	public ResponseEntity<PlayList> createNewPlatList(@RequestBody PlayListRequest pr) {
		return new ResponseEntity<PlayList>(ps.createPlayList(pr),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PlayList> getPlayListById(@PathVariable Long id){
		return new ResponseEntity<PlayList>(ps.getPlayListById(id),HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deletePlayList(@PathVariable Long id) {
		ps.deletePlayList(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
