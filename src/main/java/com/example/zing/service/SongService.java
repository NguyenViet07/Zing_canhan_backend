package com.example.zing.service;


import com.example.zing.model.Song;

public interface SongService {
    // tra ve mot mang
    Iterable<Song> findAll();
    //tra ve mot kieu doi tuong
    Song findById(Long id);
    void save(Song song);
    void delete(Long id);
}
