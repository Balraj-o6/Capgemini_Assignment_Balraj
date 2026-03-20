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

import com.music.streaming.platform.dto.ArtistRequest;
import com.music.streaming.platform.model.Artist;
import com.music.streaming.platform.service.ArtistService;

@RestController
@RequestMapping("music/platform/v1/artists")
public class ArtistController {
	
	@Autowired
	private ArtistService as;
	
	@PostMapping
	public ResponseEntity<Artist> createNewArtist(@RequestBody ArtistRequest ar) {
		return new ResponseEntity<Artist>(as.createArtist(ar),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Artist>> getAllArtist(){
		return new ResponseEntity<List<Artist>>(as.getAllArtists(),HttpStatusCode.valueOf(200));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Artist> getArtistById(@PathVariable Long id) {
		return new ResponseEntity<Artist>(as.getArtistById(id),HttpStatusCode.valueOf(200));
	}
	
	@PutMapping("/{artistId}")
	public ResponseEntity<Artist> updateArtist(@PathVariable Long artistId, @RequestBody ArtistRequest artistRequest) {
		return new ResponseEntity<Artist>(as.updateArtist(artistId, artistRequest),HttpStatusCode.valueOf(200));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteArtist(@PathVariable Long id) {
		as.deleteArtist(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
}
