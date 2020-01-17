package com.example.zing.controller;


import com.example.zing.model.Song;
import com.example.zing.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;
    @GetMapping
    public ResponseEntity<Iterable<Song>>listSong(){
        Iterable<Song> songs = songService.findAll();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Iterable<Song>>createSong(@RequestBody Song song){
        songService.save(song);
        Iterable<Song> songs = songService.findAll();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteSong(@PathVariable Long id ){
        Song song = songService.findById(id);
        if (song == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        songService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Void>updateSong(@RequestBody Song song){
        songService.save(song);
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
