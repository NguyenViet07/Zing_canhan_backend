package com.example.zing.service.impl;


import com.example.zing.model.Song;
import com.example.zing.repository.SongRepository;
import com.example.zing.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongRepository songRepository;
    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        Optional<Song> song = songRepository.findById(id);
        if (song.isPresent()){
            return song.get();
        }
        return null;
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void delete(Long id) {
        Optional<Song> song1=songRepository.findById(id);
        if (song1.isPresent()){
            songRepository.delete(song1.get());
        }
    }

}
