package com.nayak.movievideo.service.user;

import com.nayak.movievideo.application.constant.UserConstant;
import com.nayak.movievideo.domain.user.User;
import com.nayak.movievideo.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by nayak on 2018. 9. 23..
 */
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return userRepository.findUserByUserIdAndIsUsed(userId, UserConstant.ABLE).orElse(new User());
    }
}
