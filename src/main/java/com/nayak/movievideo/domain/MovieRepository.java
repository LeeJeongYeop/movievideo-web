package com.nayak.movievideo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nayak on 2018. 6. 3..
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
