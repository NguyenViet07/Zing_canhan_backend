package com.example.zing.repository;


import com.example.zing.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

}
