package com.nayak.movievideo.service.user;

import com.nayak.movievideo.application.constant.UserConstant;
import com.nayak.movievideo.domain.user.User;
import com.nayak.movievideo.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by nayak on 2018. 9. 23..
 */
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByUserIdAndIsUsed(userId, UserConstant.ABLE);
        if (!user.isPresent()) {
            throw new UsernameNotFoundException(userId);
        }
        return user.get();
    }

    public User saveUser(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        user.setIsUsed(UserConstant.ABLE);
        return userRepository.save(user);
    }

    public Boolean isAlreadyUserId(String userId) {
        return userRepository.findUserByUserIdAndIsUsed(userId, UserConstant.ABLE).isPresent();
    }
}
