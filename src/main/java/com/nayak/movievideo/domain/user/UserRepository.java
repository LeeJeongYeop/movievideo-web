package com.nayak.movievideo.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by nayak on 2018. 9. 23..
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserIdAndIsUsed(String userId, Integer isUsed);
}
