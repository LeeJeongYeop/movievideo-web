package com.nayak.movievideo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nayak on 2018. 6. 6..
 */
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findVideoByMovieTitle(String movieTitle);
    Video findVideoByVideoId(String videoId);
}
