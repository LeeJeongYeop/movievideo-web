package com.nayak.movievideo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by nayak on 2018. 6. 6..
 */
@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    Set<Video> findVideoByMovieTitle(String movieTitle);
}
